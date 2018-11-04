package hu.food.bean;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.core.entity.enums.RoleEnum;
import hu.food.util.BeanUtil;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ViewScoped
@Named("indexMBean")
public class IndexMBean extends AbstractViewBean implements Serializable {

    public void redirectToDemo() {
        BeanUtil.redirectToUrl("/xhtml/demo.xhtml");
    }

    @Override
    public List<RoleEnum> getRoles() {
        return Collections.singletonList(RoleEnum.ADMINISTRATOR);
    }
}