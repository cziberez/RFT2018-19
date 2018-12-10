package hu.food.bean.abstractbean;

import hu.food.bean.theme.ThemeBean;
import hu.food.common.LocaleEnum;
import hu.food.common.Theme;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class AbstractUserBean implements Serializable {

    private String theme;
    private String localeAsString;
    private String selectedLang;
    private Cookie localeCookie;

    @Inject
    private ThemeBean themeBean;

    @PostConstruct
    private void init() {
        theme = getTheme();
        localeAsString = getLocaleAsString();
    }

    protected Cookie getCookieByName(String cookieName) {
        Cookie retCookie = null;
        Cookie[] cookies = getServletRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    retCookie = cookie;
                }
            }
        }
        return retCookie;
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
        boolean ret = false;
        for (LocaleEnum localeEnum : LocaleEnum.values()) {
            if (localeEnum.getCountryCode().equals(localeName)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    private HttpServletRequest getServletRequest() {
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

    public void saveLocale() {
        String locale = getSelectedLang();
        if (locale != null) {
            Map<String, Object> cookieProps = new HashMap<>();
            cookieProps.put("maxAge", 365 * 24 * 60 * 60);
            cookieProps.put("path", "/");
            FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("locale", locale, cookieProps);
        }
    }

    public String getLocaleAsString() {
        String defaultLocale = System.getProperty("user.language");
        localeCookie = getCookieByName("locale");
        if (localeCookie != null) {
            String localeCookieValue = localeCookie.getValue();
            if (isLocaleAvailable(localeCookieValue)) {
                defaultLocale = localeCookieValue;
            }
        }
        return defaultLocale;
    }

    public boolean checkLangaugeDialogVisibility() {
        localeCookie = getCookieByName("locale");
        boolean ret = false;
        if (localeCookie == null) {
            ret = true;
        }
        return ret;
    }

    public Theme getThemeAsObject() {
        return themeBean.getThemes().get(0);
    }

    public String getSelectedLang() {
        return selectedLang;
    }

    public void setSelectedLang(String selectedLang) {
        this.selectedLang = selectedLang;
    }

    public String getMessageByKey(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages.Messages");
        return bundle.getString(key);
    }
}
