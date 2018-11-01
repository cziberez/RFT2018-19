package hu.food.bean.user;


import hu.food.bean.abstractbean.AbstractSessionBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.Cookie;

@Named("userBean")
@SessionScoped
public class userBean extends AbstractSessionBean {

    @Override
    public String getTheme() {
        String theme = super.getTheme();
        Cookie[] cookies = getServletRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("theme")) {
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
}
