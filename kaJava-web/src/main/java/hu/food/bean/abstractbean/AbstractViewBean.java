package hu.food.bean.abstractbean;

import hu.food.bean.user.UserMBean;
import hu.food.service.enums.Role;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractViewBean implements Serializable {

    private Cookie localeCookie;

    private boolean renderCreateEditPanel;

    private boolean renderDetailsPanel;

    @Inject
    private UserMBean userMBean;

    @PostConstruct
    private void init() {
        List<Role> requiredRole = getRoles();
        checkRole(requiredRole);
        renderCreateEditPanel = false;
        renderDetailsPanel = false;
    }

    public abstract List<Role> getRoles();

    private boolean hasRole(List<Role> roles) {
        boolean ret = false;
        final UserVo userVo = userMBean.getUserVo();
        for (Role role : roles) {
            if (role.equals(userVo.getRole())) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    private void checkRole(List<Role> roles) {
        if(roles != null) {
            if (!hasRole(roles)) {
                redirectToDeniedPage();
            }
        }
    }

    private void redirectToDeniedPage() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/denied.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cookie getLocaleCookie() {
        return localeCookie;
    }

    public void setLocaleCookie(Cookie localeCookie) {
        this.localeCookie = localeCookie;
    }

    public boolean isRenderCreateEditPanel() {
        return renderCreateEditPanel;
    }

    public boolean isRenderDetailsPanel() {
        return renderDetailsPanel;
    }

    public void setRenderCreateEditPanel(boolean renderCreateEditPanel) {
        this.renderCreateEditPanel = renderCreateEditPanel;
    }


    public void setRenderCreateEditPanel() {
        renderCreateEditPanel = true;
        renderDetailsPanel = false;
    }

    public void destroyCreateEditPanel() {
        renderCreateEditPanel = false;
    }

    public void setDetailsPanelRendered() {
        renderDetailsPanel = true;
        renderCreateEditPanel = false;
    }

    public void destroyDetailsPanelRendered() {
        renderDetailsPanel = false;
    }

    public void falseAllPanel() {
        renderCreateEditPanel = false;
        renderDetailsPanel = false;
    }

    public void setRenderDetailsPanel(boolean renderDetailsPanel) {
        this.renderDetailsPanel = renderDetailsPanel;
    }

    public UserMBean getUserMBean() {
        return userMBean;
    }

    public void setUserMBean(UserMBean userMBean) {
        this.userMBean = userMBean;
    }
}
