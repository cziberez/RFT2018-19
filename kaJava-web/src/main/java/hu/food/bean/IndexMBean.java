package hu.food.bean;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.core.entity.enums.RoleEnum;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;
import hu.food.util.BeanUtil;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ViewScoped
@Named("indexMBean")
public class IndexMBean extends AbstractViewBean {

    @Inject
    private UserService userService;

    private UserVo userVo;

    @PostConstruct
    private void init() {
        userVo = new UserVo();
    }

    public void saveNewUser() {
        userService.save(userVo);
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    @Override
    public List<RoleEnum> getRoles() {
        return Collections.singletonList(RoleEnum.ADMINISTRATOR);
    }
}