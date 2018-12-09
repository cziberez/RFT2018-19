package hu.food.bean.locale;

import hu.food.bean.abstractbean.AbstractUserBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.util.Locale;

@ViewScoped
@Named("localeMBean")
public class LocaleMBean extends AbstractUserBean {

    public Locale getLocaleByCookie() {
        Cookie localeCookie = getCookieByName("locale");
        Locale defaultLocale = null; //igen, null, mert ha ezzel tér vissza, akkor system default-ot fog használni
        if (localeCookie != null) {
            String localeValue = localeCookie.getValue();
            if (localeValue != null && isLocaleAvailable(localeValue)) {
                defaultLocale = Locale.forLanguageTag(localeValue);
                FacesContext.getCurrentInstance().getViewRoot().setLocale(defaultLocale);
            }
        }
        return defaultLocale;
    }

}
