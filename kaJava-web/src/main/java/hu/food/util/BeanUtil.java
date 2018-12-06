package hu.food.util;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BeanUtil {

    public static Locale getLocaleFromCountry(String country) {
        Map<String, Locale> COUNTRY_TO_LOCALE_MAP = new HashMap<String, Locale>();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale l : locales) {
            COUNTRY_TO_LOCALE_MAP.put(l.getCountry(), l);
        }
        return COUNTRY_TO_LOCALE_MAP.get(country);
    }

    public static void redirectToUrl(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
