package hu.food.service.impl;

import hu.food.core.dao.AddressDao;
import hu.food.core.dao.FoodDao;
import hu.food.core.dao.OrderDao;
import hu.food.core.dao.UserDao;
import hu.food.core.entity.Order;
import hu.food.service.enums.Role;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.mapper.FoodMapper;
import hu.food.service.mapper.OrderMapper;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.OrderService;
import hu.food.service.vo.FoodVo;
import hu.food.service.vo.OrderVo;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @EJB
    private OrderDao orderDao;

    @EJB
    private AddressDao addressDao;

    @EJB
    private UserDao userDao;

    private UserMapper userMapper;

    private AddressMapper addressMapper;

    private OrderMapper orderMapper;

    @PostConstruct
    public void init() {
        addressMapper = new AddressMapper();
        userMapper = new UserMapper();
        orderMapper = new OrderMapper();
    }

    @Override
    public boolean makeAnOrder(UserVo userVo, OrderVo order, List<FoodVo> basket) {
        if (userVo.getId() == null) {
            userVo.setRole(Role.GUEST);
            order.setCustomer(userMapper.toVo(userDao.find(userDao.save(userMapper.toEntity(userVo)))));

        } else {
            order.setCustomer(userMapper.toVo(userDao.find(userVo.getId())));
        }
        order.setOrderedFood(basket);

        orderDao.save(orderMapper.toEntity(order));
        return true;
    }

    @Override
    public List<OrderVo> findOrdersByUser(Long userId) {

        return orderMapper.toVo(orderDao.findAll()
                .stream()
                .filter(f -> f.getCustomer().getId().equals(userId))
                .collect(Collectors.toList()));
    }
}
