package hu.food.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import hu.food.core.dao.impl.FoodDaoImpl;
import hu.food.core.entity.Food;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.FoodMapper;
import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Default
@Dependent
public class FoodServiceImpl implements FoodService{
	
	@Default
	private FoodDaoImpl foodDao;
	
	@Default
	private FoodMapper mapper;
	
	@Override
	public void save(FoodVo vo) {
		foodDao.save(mapper.toEntity(vo));
	}

	@Override
	public void saveAll(List<FoodVo> voList) {
		voList.stream().forEach(fe -> foodDao.save(mapper.toEntity(fe)));
	}

	@Override
	public FoodVo find(Long id) {
		
		return mapper.toVo(foodDao.findById(id));
	}

	@Override
	public List<FoodVo> findAll() {
	
		return mapper.toVo(foodDao.findAll());
	}

	@Override
	public void setDeleted(FoodVo vo) {
		Food food = mapper.toEntity(vo);
		
		food.setStatus(StatusEnum.DELETED);
		
		foodDao.setDeleted(food);		
	}

	@Override
	public void setActive(FoodVo vo) {
		Food food = mapper.toEntity(vo);
		
		food.setStatus(StatusEnum.ACTIVE);
		
		foodDao.setDeleted(food);
	}
}
