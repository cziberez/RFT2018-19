package hu.food.web.bean;

import hu.food.service.UserService;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("userBean")
@ViewScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UserService userService;

    private UserVo userVo;

    private AddressVo addressVo;

    @PostConstruct
    public void init() {
        userVo = new UserVo();
        addressVo = new AddressVo();
    }

    public void addUser() {
        userService.saveNewUser(userVo, addressVo);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public AddressVo getAddressVo() {
        return addressVo;
    }

    public void setAddressVo(AddressVo addressVo) {
        this.addressVo = addressVo;
    }
}
