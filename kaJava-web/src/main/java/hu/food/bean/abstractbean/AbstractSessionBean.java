package hu.food.bean.abstractbean;

import hu.food.view.Theme;
import hu.food.view.ThemeBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
public class AbstractSessionBean implements Serializable {

    private String theme;

    @Inject
    private ThemeBean themeBean;

    @PostConstruct
    private void init() {
        theme = getTheme();
    }

    public String getTheme() {
        return themeBean.getThemes().get(0).getName();
    }

    protected boolean isThemeAvailable(String theme) {
        for (Theme themes : themeBean.getThemes()) {
            if (theme.equals(themes.getName())) {
                return true;
            }
        }

        return false;
    }

    protected HttpServletRequest getServletRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public void saveTheme(AjaxBehaviorEvent evt) {
        Object themeValue = ((UIInput) evt.getSource()).getValue();

        if (themeValue != null) {
            Map<String, Object> cookieProps = new HashMap<>();

            cookieProps.put("maxAge", 365 * 24 * 60 * 60);
            cookieProps.put("path", "/");
            FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("theme", themeValue.toString(), cookieProps);
        }
    }
}
