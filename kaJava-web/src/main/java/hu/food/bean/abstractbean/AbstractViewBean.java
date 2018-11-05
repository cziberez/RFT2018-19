package hu.food.bean.abstractbean;

import hu.food.core.entity.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
public abstract class AbstractViewBean implements Serializable {

    private Cookie localeCookie;

    @PostConstruct
    private void init() {
        List<RoleEnum> requiredRole = getRoles();
        checkRole(requiredRole);
    }

    public abstract List<RoleEnum> getRoles();

    private boolean hasRole(List<RoleEnum> roles) {
        return false;
    }

    private void checkRole(List<RoleEnum> roles) {
        if (hasRole(roles)) {
            redirectToDeniedPage();
        }
    }

    private void redirectToDeniedPage() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/denied.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
