package hu.food.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;


//TODO kirillab: ezt is mozgatni a Vo-ba és megírni dinamikusan
@Named("breadCrumbVo")
@ViewScoped
public class BreadCrumbVo implements Serializable {

	private static final long serialVersionUID = 1L;
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