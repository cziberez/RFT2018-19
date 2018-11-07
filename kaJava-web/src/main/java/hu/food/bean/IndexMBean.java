package hu.food.bean;

import java.util.Collections;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Roles;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;

@ViewScoped
@Named("indexMBean")
public class IndexMBean extends AbstractViewBean {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{userService}")
    private UserService userService;

    private UserVo userVo;

    public void saveNewUser() {
        userVo = new UserVo();
        userService.save(userVo);
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Roles> getRoles() {
        return Collections.singletonList(Roles.ADMINISTRATOR);
    }
}