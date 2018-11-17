package hu.food.bean;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Roles;
import hu.food.service.services.UserService;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ViewScoped
@Named("indexMBean")
@Getter
@Setter
public class IndexMBean extends AbstractViewBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserService userService;

    private UserVo userVo;

    private AddressVo addressVo;

    public void createContact() {
        userVo = new UserVo();
        addressVo = new AddressVo();
    }

    public void saveNewUser() {
        userService.saveNewUser(userVo, addressVo);
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    @Override
    public List<Roles> getRoles() {
        return Collections.singletonList(Roles.ADMINISTRATOR);
    }

    public AddressVo getAddressVo() {
        return addressVo;
    }

    public void setAddressVo(AddressVo addressVo) {
        this.addressVo = addressVo;
    }
}