package hu.food.bean.admin;

import hu.food.service.enums.Role;
import hu.food.service.services.AdministrationService;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("adminBean")
@ViewScoped
public class AdministrationBean implements Serializable {

    @EJB
    private AdministrationService adminService;

    @EJB
    private UserService userService;

    private List<UserVo> users;

    private UserVo selectedUser;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
    }

    public void changeUserRole(UserVo user, Role role){
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

}
