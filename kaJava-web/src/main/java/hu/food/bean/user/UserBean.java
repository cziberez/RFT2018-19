package hu.food.bean.user;


import hu.food.bean.abstractbean.AbstractSessionBean;
import hu.food.bean.theme.ThemeBean;
import hu.food.view.Theme;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Locale;

@Named("userBean")
@SessionScoped
public class UserBean extends AbstractSessionBean {

    private Locale locale;

    @Inject
    private ThemeBean themeBean;

    @Override
    public String getTheme() {
        String theme = super.getTheme();
        Cookie[] cookies = getServletRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("theme".equals(cookie.getName())) {
                    String cookieValue = cookie.getValue();
                    if (isThemeAvailable(cookieValue)) {
                        theme = cookieValue;
                    }
                    break;
                }
            }
        }
        return theme;
    }

    @Override
    public Locale loadLocale() {
        Locale locale = super.loadLocale();
        Cookie[] cookies = getServletRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("locale".equals(cookie.getName())) {
                    String localeValue = cookie.getValue();
                    if (isLocaleAvailable(localeValue)) {
                        locale = new Locale(localeValue);
                        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
                    }
                } else {
                    locale = null;
                }
            }
        }
        return locale;
    }
}
