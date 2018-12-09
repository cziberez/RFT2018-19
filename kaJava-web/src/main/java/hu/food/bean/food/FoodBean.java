package hu.food.bean.food;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Named("foodBean")
@ViewScoped
public class FoodBean extends AbstractViewBean {

    @EJB
    private FoodService foodService;

    private List<FoodVo> foods;

    private FoodVo selectedFood;

    @PostConstruct
    public void init() {
        foods = foodService.findAll();
        selectedFood = new FoodVo();
    }

    public FoodService getFoodService() {
        return foodService;
    }

    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    public List<FoodVo> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodVo> foods) {
        this.foods = foods;
    }

    public FoodVo getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(FoodVo selectedFood) {
        this.selectedFood = selectedFood;
    }

    public void addToCard(FoodVo foodVo) {

    }

    public void saveFood() {

    }

    @Override
    public List<Role> getRoles() {
        return Arrays.asList(Role.CUSTOMER, Role.ADMINISTRATOR, Role.DELIVER);
    }
}
