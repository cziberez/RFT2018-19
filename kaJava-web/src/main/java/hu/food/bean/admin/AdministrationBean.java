package hu.food.bean.admin;

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
import java.util.Collections;
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

    private List<Role> roles;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
        roles = Arrays.asList(Role.values());
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

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public List<Role> getRoles() {
        return Collections.singletonList(Role.ADMINISTRATOR);
    }

}
