package hu.food.bean.abstractbean;

import hu.food.bean.theme.ThemeBean;
import hu.food.view.LocaleEnum;
import hu.food.view.Theme;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Getter
@Setter
public abstract class AbstractUserBean implements Serializable {

    private String theme;
    private String localeAsString;
    private String selectedLang;
    private Cookie localeCookie;

    @Inject
    private ThemeBean themeBean;

    @PostConstruct
    public void init() {
        theme = getTheme();
        localeAsString = getLocaleAsString();
        localeCookie = getCookieByName("locale");
        setupLocaleByCookie();
    }

    public Cookie getCookieByName(String cookieName) {
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

    private boolean isLocaleAvailable(String localeName) {
        boolean ret = true;
        for (LocaleEnum localeEnum : LocaleEnum.values()) {
            if (localeEnum.getCountryCode().equals(localeName)) {
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

    private void setupLocaleByCookie() {
        if (localeCookie != null) {
            String localeValue = localeCookie.getValue();
            if (localeValue != null && isLocaleAvailable(localeValue)) {
                Locale setupLocale = new Locale(localeValue);
                FacesContext.getCurrentInstance().getViewRoot().setLocale(setupLocale);
            }
        }
    }


    public String getLocaleAsString() {
        String defaultLocale = System.getProperty("user.language");
        if (localeCookie != null) {
            String localeCookieValue = localeCookie.getValue();
            if (isLocaleAvailable(localeCookieValue)) {
                defaultLocale = localeCookieValue;
            }
        }
        return defaultLocale;
    }

    public boolean checkLangaugeDialogVisibility() {
        boolean ret = false;
        if (localeCookie == null) {
            ret = true;
        }
        return ret;
    }

    public Theme getThemeAsObject() {
        return themeBean.getThemes().get(0);
    }
}
