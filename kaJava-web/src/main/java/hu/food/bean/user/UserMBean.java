package hu.food.bean.user;

import hu.food.bean.abstractbean.AbstractUserBean;
import hu.food.bean.theme.ThemeBean;
import hu.food.common.SessionEnum;
import hu.food.common.Theme;
import hu.food.service.services.UserService;
import hu.food.service.enums.Role;
import hu.food.service.vo.UserVo;
import hu.food.util.ContextUtil;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.io.IOException;

@Named("userBean")
@SessionScoped
public class UserMBean extends AbstractUserBean {

    private String selectedLang;

    @Inject
    private ThemeBean themeBean;

    @EJB
    private UserService userService;

    private UserVo userVo;

    @Override
    public String getTheme() {
        String theme = super.getTheme();
        Cookie themeCookie = getCookieByName("theme");
        if (themeCookie != null) {
            theme = themeCookie.getValue();
        }
        return theme;
    }

    @Override
    public Theme getThemeAsObject() {
        Theme themeAsObject = super.getThemeAsObject();
        Cookie themeCookie = getCookieByName("theme");
        if (themeCookie != null) {
            for (Theme theme : themeBean.getThemes()) {
                if (themeCookie.getValue().equals(theme.getName())) {
                    themeAsObject = theme;
                }
            }
        }
        return themeAsObject;
    }

    @Override
    public String getSelectedLang() {
        return super.getSelectedLang();
    }

    @Override
    public void setSelectedLang(String selectedLang) {
        super.setSelectedLang(selectedLang);
    }

    public void createUser() {
        destroyUser();
        userVo = new UserVo();
    }

    public void modifyAddress() {
        userService.modifyAddress(userVo);
    }

    private void destroyUser() {
        userVo = null;
    }

    public void registerUser() {
        userVo.setRole(Role.CUSTOMER);
        userService.addUser(userVo);
        destroyUser();
        ContextUtil.addMessage(null, FacesMessage.SEVERITY_INFO, "Regisztrálva", "Regisztálva");
    }

    public ThemeBean getThemeBean() {
        return themeBean;
    }

    public void setThemeBean(ThemeBean themeBean) {
        this.themeBean = themeBean;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public void login() {
        doLogin();
    }

    public void logout() {
        doLogout();
    }

    private void doLogin() {
        userVo = userService.authenticateUser(userVo.getUsername());
        if (userVo == null) {
            //TODO Czibere growl Message nincs ilyen user :/
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(SessionEnum.LOGINSTATE.getName(), "true");
        }
    }

    private void doLogout() {
        try {
            destroyUser();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/index.xhtml");
        } catch (IOException e) {

        }
    }

    public boolean isLoggedIn() {
        return userVo != null;
    }
}
