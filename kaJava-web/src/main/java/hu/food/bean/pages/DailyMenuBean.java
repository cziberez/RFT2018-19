package hu.food.bean.pages;


import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.services.FoodService;
import hu.food.service.vo.DailyMenuVo;
import hu.food.service.vo.FoodVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named("dailyMenuBean")
@ViewScoped
public class DailyMenuBean extends AbstractViewBean {

    @EJB
    private FoodService foodService;

    private DailyMenuVo dailyMenu;

    private DailyMenuVo newDailyMenu;

    private List<FoodVo> mainDishes;

    private List<FoodVo> soups;

    private List<DailyMenuVo> allMenu;

    @PostConstruct
    public void init() {
        newDailyMenu = new DailyMenuVo();
        mainDishes = foodService.findByCategory("Főételek");
        soups = foodService.findByCategory("Levesek");
        allMenu = foodService.findAllMenu();
        dailyMenu = foodService.getDailyMenu(new Date().toString().substring(8, 10));
    }

    public void saveNewDailyMenu() {
        foodService.saveDailyMenu(newDailyMenu);
    }

    @Override
    public List<Role> getRoles() {
        return null;
    }

    public DailyMenuVo getDailyMenu() {
        return dailyMenu;
    }

    public void setDailyMenu(DailyMenuVo dailyMenu) {
        this.dailyMenu = dailyMenu;
    }

    public DailyMenuVo getNewDailyMenu() {
        return newDailyMenu;
    }

    public void setNewDailyMenu(DailyMenuVo newDailyMenu) {
        this.newDailyMenu = newDailyMenu;
    }

    public List<FoodVo> getMainDishes() {
        return mainDishes;
    }

    public void setMainDishes(List<FoodVo> mainDishes) {
        this.mainDishes = mainDishes;
    }

    public List<FoodVo> getSoups() {
        return soups;
    }

    public void setSoups(List<FoodVo> soups) {
        this.soups = soups;
    }
}
