package hu.food.service.services;

import hu.food.service.vo.DeliverVo;
import hu.food.service.vo.FoodVo;
import hu.food.service.vo.OrderVo;
import hu.food.service.vo.UserVo;

import java.util.List;

public interface OrderService {

    boolean makeAnOrder(UserVo userVo, OrderVo order, List<FoodVo> basket);

    List<OrderVo> findOrdersByUser(Long userId);

    DeliverVo getLaziestDeliver();
}
