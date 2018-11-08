package hu.food.bean.abstractbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

import hu.food.service.enums.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractViewBean implements Serializable {

    private Cookie localeCookie;

    @PostConstruct
    private void init() {
        List<Roles> requiredRole = getRoles();
        checkRole(requiredRole);
    }

    public abstract List<Roles> getRoles();

    private boolean hasRole(List<Roles> roles) {
        return false;
    }

    private void checkRole(List<Roles> roles) {
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
