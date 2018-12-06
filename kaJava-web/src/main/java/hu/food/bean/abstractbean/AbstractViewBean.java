package hu.food.bean.abstractbean;

import hu.food.service.enums.Role;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractViewBean implements Serializable {

    private Cookie localeCookie;

    @PostConstruct
    private void init() {
        List<Role> requiredRole = getRoles();
        checkRole(requiredRole);
    }

    public abstract List<Role> getRoles();

    private boolean hasRole(List<Role> roles) {
        return false;
    }

    private void checkRole(List<Role> roles) {
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
