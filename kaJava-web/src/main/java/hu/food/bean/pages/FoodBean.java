package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.bean.user.UserMBean;
import hu.food.service.enums.Role;
import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;


@Named("foodBean")
@ViewScoped
public class FoodBean extends AbstractViewBean {

    @EJB
    private FoodService foodService;

    private List<FoodVo> foods;

    private FoodVo selectedFood;

    private UploadedFile file;

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
        if(selectedFood != null) {
            foodService.saveFood(selectedFood);
        }
        foods = foodService.findAll();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {

    }

    @Override
    public List<Role> getRoles() {
        return null;
    }
}
