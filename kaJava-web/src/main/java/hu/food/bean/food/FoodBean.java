package hu.food.bean.food;

import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("foodBean")
@ViewScoped
public class FoodBean implements Serializable {

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
}
