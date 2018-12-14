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
        foods = foodService.findAllActive();
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

    public void saveFood() {
        if(selectedFood != null) {
            selectedFood.setStatus(StatusEnum.ACTIVE);
            foodService.saveFood(selectedFood);
        }
        foods = foodService.findAllActive();
    }

    public void deleteFood(FoodVo food) {
        foodService.deleteLogical(food);
    }

    @Override
    public List<Role> getRoles() {
        return null;
    }
}
