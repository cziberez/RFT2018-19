package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.services.AdministrationService;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named("adminBean")
@ViewScoped
public class AdministrationBean extends AbstractViewBean {

    @EJB
    private AdministrationService adminService;

    @EJB
    private UserService userService;

    private List<UserVo> users;

    private UserVo selectedUser;

    private List<Role> rolesEnum;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
        rolesEnum = getRolesEnum();
        getRolesEnum();
    }

    public void changeUserRole(UserVo user, Role role) {
        adminService.giveRoleToUser(user, role);
    }

    public AdministrationService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdministrationService adminService) {
        this.adminService = adminService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<UserVo> getUsers() {
        return users;
    }

    public void setUsers(List<UserVo> users) {
        this.users = users;
    }

    public UserVo getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserVo selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Role> getRolesEnum() {
        return Arrays.asList(Role.values());
    }

    public void setRolesEnum(List<Role> rolesEnum) {
        this.rolesEnum = rolesEnum;
    }

    @Override
    public List<Role> getRoles() {
        return Arrays.asList(Role.ADMINISTRATOR, Role.SHOPRENTER);
    }

    @Override
    public void setDetailsPanelRendered() {
        if (selectedUser != null) {
            falseAllPanel();
            super.setDetailsPanelRendered();
        }
    }

    @Override
    public void setRenderCreateEditPanel(boolean renderCreateEditPanel) {
        if (selectedUser != null) {
            falseAllPanel();
            super.setRenderCreateEditPanel(renderCreateEditPanel);
        }
    }
}
