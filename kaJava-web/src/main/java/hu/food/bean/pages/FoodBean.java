package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.enums.StatusEnum;
import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;
import hu.food.util.ContextUtil;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named("foodBean")
@ViewScoped
public class FoodBean extends AbstractViewBean {

    @EJB
    private FoodService foodService;

    private List<FoodVo> foods;

    private FoodVo selectedFood;

    private Boolean isSoup;

    private Boolean isMainDishes;

    private Boolean isPizza;

    private Boolean isDessert;

    @PostConstruct
    private void init() {
        foods = getAllActiveFood();
        selectedFood = new FoodVo();
        isSoup = true;
        isMainDishes = true;
        isPizza = true;
        isDessert = true;
    }

    public void searchForFood(){
        foods = new ArrayList<>();
        if(isSoup){
            foods.addAll(foodService.findByCategory("Levesek"));
        }
        if(isMainDishes){
            foods.addAll(foodService.findByCategory("Főételek"));
        }
        if(isPizza){
            foods.addAll(foodService.findByCategory("Pizzák"));
        }
        if(isDessert){
            foods.addAll(foodService.findByCategory("Desszertek"));
        }
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

    public void saveFood() {
        if(selectedFood != null) {
            selectedFood.setStatus(StatusEnum.ACTIVE);
            foodService.saveFood(selectedFood);
            selectedFood = new FoodVo();
            foods = getAllActiveFood();
        }
    }

    private List<FoodVo> getAllActiveFood() {
        return foodService.findAllActive();
    }

    public void deleteFood(FoodVo food) {
        foodService.deleteLogical(food);
        foods = getAllActiveFood();
    }

    public void setActualFoodModify(FoodVo foodVo) {
        selectedFood = foodVo;
    }

    @Override
    public List<Role> getRoles() {
        return null;
    }

    public Boolean getSoup() {
        return isSoup;
    }

    public void setSoup(Boolean soup) {
        isSoup = soup;
    }

    public Boolean getMainDishes() {
        return isMainDishes;
    }

    public void setMainDishes(Boolean mainDishes) {
        isMainDishes = mainDishes;
    }

    public Boolean getPizza() {
        return isPizza;
    }

    public void setPizza(Boolean pizza) {
        isPizza = pizza;
    }

    public Boolean getDessert() {
        return isDessert;
    }

    public void setDessert(Boolean dessert) {
        isDessert = dessert;
    }
}
