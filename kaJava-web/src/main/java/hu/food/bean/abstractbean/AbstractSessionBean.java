package hu.food.bean.abstractbean;

import hu.food.bean.theme.ThemeBean;
import hu.food.view.LocaleEnum;
import hu.food.view.Theme;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractSessionBean implements Serializable {

    private String theme;
    private Locale locale;

    @Inject
    private ThemeBean themeBean;

    @PostConstruct
    private void init() {
        theme = getTheme();
        locale = loadLocale();
    }

    public String getTheme() {
        return themeBean.getThemes().get(0).getName();
    }

    protected boolean isThemeAvailable(String themeName) {
        for (Theme themes : themeBean.getThemes()) {
            if (themeName.equals(themes.getName())) {
                return true;
            }
        }

        return false;
    }

    protected boolean isLocaleAvailable(String localeName) {
        boolean ret = true;
        for (LocaleEnum localeEnum : LocaleEnum.values()) {
            if (localeEnum.getName().equals(localeName)) {
                ret = true;
                break;
            }
        }
        return ret;
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

    public Locale loadLocale() {
        return getServletRequest().getLocale();
    }

    public boolean isLocaleSet() {
        return true;
    }
}
