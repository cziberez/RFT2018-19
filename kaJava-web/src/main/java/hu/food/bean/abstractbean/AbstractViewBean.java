package hu.food.bean.abstractbean;

import hu.food.core.entity.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public abstract class AbstractViewBean implements Serializable {

    private static final long serialVersionUID = -744738568889251726L;

    @PostConstruct
    private void init() {
        List<RoleEnum> kapottJog = getRoles();
        checkRole(kapottJog);
    }

    public abstract List<RoleEnum> getRoles();

    private boolean hasRole(List<RoleEnum> roles) {
        return false;
    }

    protected void checkRole(List<RoleEnum> roles) {
        if(hasRole(roles)) {
            redirectToDeniedPage();
        }
    }

    protected void redirectToDeniedPage() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/denied.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
