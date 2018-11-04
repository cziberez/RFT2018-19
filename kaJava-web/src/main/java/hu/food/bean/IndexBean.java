package hu.food.bean;

import hu.food.bean.abstractbean.AbstractRoleBean;
import hu.food.core.entity.enums.RoleEnum;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ViewScoped
@Named("indexMBean")
public class IndexBean extends AbstractRoleBean {
    
    public void redirectToDemo() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/kaJava-web/xhtml/demo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RoleEnum> getRoles() {
        return Collections.singletonList(RoleEnum.ADMINISTRATOR);
    }
}