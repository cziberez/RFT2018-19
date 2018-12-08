package hu.food.service.mapper;

import hu.food.core.entity.Food;
import hu.food.service.vo.FoodVo;


public class FoodMapper extends GenericMapper<Food, FoodVo> {

	private static final long serialVersionUID = 1L;

	public FoodMapper(Class<FoodVo> voClazz, Class<Food> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public FoodMapper() {
		super(FoodVo.class, Food.class);
	}
}
