package hu.food.service.impl;

import hu.food.core.dao.FoodDao;
import hu.food.service.mapper.FoodMapper;
import hu.food.service.services.FoodService;
import hu.food.service.vo.FoodVo;

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

    @PostConstruct
    public void init() {
        foodMapper = new FoodMapper();
    }

    @Override
    public List<FoodVo> findAll() {

        return foodMapper.toVo(foodDao.findAll());
    }
}
