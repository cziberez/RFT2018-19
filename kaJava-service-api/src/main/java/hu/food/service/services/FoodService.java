package hu.food.service.services;

import hu.food.service.vo.DailyMenuVo;
import hu.food.service.vo.FoodVo;

import java.util.List;

public interface FoodService {

    List<FoodVo> findAll();

    List<FoodVo> findAllActive();

    void saveFood(FoodVo food);

    void deleteFood(FoodVo food);

    void deleteLogical(FoodVo food);

    List<FoodVo> findByCategory(String category);

    void saveDailyMenu(DailyMenuVo menu);

    DailyMenuVo getDailyMenu(String day);

    List<DailyMenuVo> findAllMenu();
}
