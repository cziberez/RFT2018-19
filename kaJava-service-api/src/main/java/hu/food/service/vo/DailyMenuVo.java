package hu.food.service.vo;

public class DailyMenuVo extends BaseVo {

    private FoodVo mainDishes;

    private FoodVo soup;

    private String date;

    public DailyMenuVo() {
    }

    public DailyMenuVo(FoodVo mainDishes, FoodVo soup, String date) {
        this.mainDishes = mainDishes;
        this.soup = soup;
        this.date = date;
    }

    public FoodVo getMainDishes() {
        return mainDishes;
    }

    public void setMainDishes(FoodVo mainDishes) {
        this.mainDishes = mainDishes;
    }

    public FoodVo getSoup() {
        return soup;
    }

    public void setSoup(FoodVo soup) {
        this.soup = soup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
