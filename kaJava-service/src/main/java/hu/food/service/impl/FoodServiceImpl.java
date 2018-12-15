package hu.food.service.impl;

import hu.food.core.dao.DailyMenuDao;
import hu.food.core.dao.FoodDao;
import hu.food.core.entity.DailyMenu;
import hu.food.service.mapper.DailyMenuMapper;
import hu.food.service.mapper.FoodMapper;
import hu.food.service.services.FoodService;
import hu.food.service.vo.DailyMenuVo;
import hu.food.service.vo.FoodVo;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FoodServiceImpl implements FoodService {

    @EJB
    private FoodDao foodDao;

    private FoodMapper foodMapper;

    @EJB
    private DailyMenuDao dailyMenuDao;

    private DailyMenuMapper dailyMenuMapper;

    @PostConstruct
    public void init() {
        foodMapper = new FoodMapper();
    }

    @Override
    public List<FoodVo> findAll() {

        return foodMapper.toVo(foodDao.findAll());
    }

    @Override
    public List<FoodVo> findAllActive() {

        return foodMapper.toVo(foodDao.findAllActive());
    }

    @Override
    public void saveFood(FoodVo food) {

        foodDao.save(foodMapper.toEntity(food));
    }

    @Override
    public void deleteFood(FoodVo food) {

        foodDao.remove(food.getId());
    }

    @Override
    public void deleteLogical(FoodVo food) {

        foodDao.removeLogical(food.getId());
    }

    @Override
    public List<FoodVo> findByCategory(String category) {

        return foodMapper.toVo(foodDao.findByCategory(category));
    }

    @Override
    public void saveDailyMenu(DailyMenuVo menu) {
        dailyMenuDao.save(dailyMenuMapper.toEntity(menu));
    }

    @Override
    public DailyMenuVo getDailyMenu(String day) {
        return dailyMenuMapper.toVo(dailyMenuDao.getDailyMenu(day));
    }

    @Override
    public List<DailyMenuVo> findAllMenu() {
        return dailyMenuMapper.toVo(dailyMenuDao.findAll());
    }

}
