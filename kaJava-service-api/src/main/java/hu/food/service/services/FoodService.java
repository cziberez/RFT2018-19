package hu.food.service.services;

import hu.food.service.vo.FoodVo;

import java.util.List;

public interface FoodService {

    List<FoodVo> findAll();

    void saveFood(FoodVo food);
}
