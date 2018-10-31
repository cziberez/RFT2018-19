package hu.food.bean;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;


//TODO kirillab: ezt is mozgatni a Vo-ba és megírni dinamikusan
@Named("breadCrumbVo")
@ViewScoped
public class BreadCrumbVo implements Serializable {

    private MenuModel menuModel;

    public BreadCrumbVo() {
        menuModel = new DefaultMenuModel();
        DefaultMenuItem menuItem = new DefaultMenuItem();
        menuModel.addElement(menuItem);
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
}