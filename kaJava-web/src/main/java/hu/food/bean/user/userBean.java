package hu.food.bean.user;


import hu.food.bean.abstractbean.AbstractSessionBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.util.Locale;

@Named("userBean")
@SessionScoped
public class userBean extends AbstractSessionBean {

    private Locale locale;

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
