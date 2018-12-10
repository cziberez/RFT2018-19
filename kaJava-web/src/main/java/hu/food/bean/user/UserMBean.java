package hu.food.bean.user;

import hu.food.bean.abstractbean.AbstractUserBean;
import hu.food.bean.theme.ThemeBean;
import hu.food.common.Theme;
import hu.food.service.services.UserService;
import hu.food.service.enums.Role;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.FoodVo;
import hu.food.service.vo.OrderVo;
import hu.food.service.vo.UserVo;
import hu.food.util.ContextUtil;
import org.primefaces.event.FlowEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named("userBean")
@SessionScoped
public class UserMBean extends AbstractUserBean {

    private String selectedLang;

    @Inject
    private ThemeBean themeBean;

    @EJB
    private UserService userService;

    private List<FoodVo> basket;

    private OrderVo order;

    private UserVo userVo;

    private AddressVo addressVo;

    private String selectedPaymentType;

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

    @PostConstruct
    public void init() {
        basket = new ArrayList<>();
        selectedPaymentType = "";
        order = new OrderVo();
    }

    public void createUser() {
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

    public boolean isLoggedInAsAdmin() {
        return isLoggedIn() && Role.ADMINISTRATOR.equals(userVo.getRole());
    }

    public boolean isLoggedInAsDeliver() {
        return isLoggedIn() && Role.DELIVER.equals(userVo.getRole());
    }

    public boolean isLoggedInAsShopRenter() {
        return isLoggedIn() && (Role.SHOPRENTER.equals(userVo.getRole()) || Role.ADMINISTRATOR.equals(userVo.getRole()));
    }

    public void addFoodToBasket(FoodVo orderedFood) {
        basket.add(orderedFood);
        //TODO Czibere adhatsz faces messaget hogy sikerült a kosárművelet
    }

    public void getReadyForCheckout() {
        if (userVo == null) {
            userVo = new UserVo();
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/checkout.xhtml");
        } catch (IOException e){
            FacesMessage msg = new FacesMessage("Error", "Hiba");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void makeOrder() {
        FacesMessage msg = new FacesMessage("Successful", "Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Long getTotalPrice() {
        return basket.stream().mapToLong(m -> m.getPrice()).sum();
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    //Getter Setter section
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

    public List<FoodVo> getBasket() {
        return basket;
    }

    public void setBasket(List<FoodVo> basket) {
        this.basket = basket;
    }

    public OrderVo getOrder() {
        return order;
    }

    public void setOrder(OrderVo order) {
        this.order = order;
    }



    public AddressVo getAddressVo() {
        return addressVo;
    }

    public void setAddressVo(AddressVo addressVo) {
        this.addressVo = addressVo;
    }

    public String getSelectedPaymentType() {
        return selectedPaymentType;
    }

    public void setSelectedPaymentType(String selectedPaymentType) {
        this.selectedPaymentType = selectedPaymentType;
    }
}
