package hu.food.service.impl;

import hu.food.core.dao.*;
import hu.food.core.entity.Order;
import hu.food.service.enums.Role;
import hu.food.service.mapper.*;
import hu.food.service.services.OrderService;
import hu.food.service.vo.DeliverVo;
import hu.food.service.vo.FoodVo;
import hu.food.service.vo.OrderVo;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDao;

    @Inject
    private AddressDao addressDao;

    @Inject
    private UserDao userDao;

    @Inject
    private DeliverDao deliverDao;

    private UserMapper userMapper;

    private AddressMapper addressMapper;

    private OrderMapper orderMapper;

    private DeliverMapper deliverMapper;

    @PostConstruct
    public void init() {
        addressMapper = new AddressMapper();
        userMapper = new UserMapper();
        orderMapper = new OrderMapper();
        deliverMapper = new DeliverMapper();
    }

    @Override
    public boolean makeAnOrder(UserVo userVo, OrderVo order, List<FoodVo> basket) {
        if (userVo.getId() == null) {
            userVo.setRole(Role.GUEST);
            addressDao.save(addressMapper.toEntity(userVo.getAddressVo()));
            userVo.setAddressVo(addressMapper.toVo(addressDao.find(addressDao.save(addressMapper.toEntity(userVo.getAddressVo())))));
            order.setCustomer(userMapper.toVo(userDao.find(userDao.save(userMapper.toEntity(userVo)))));
        } else {
            order.setCustomer(userMapper.toVo(userDao.find(userVo.getId())));
        }
        order.setOrderedFood(basket);
        order.setDeliver(getLaziestDeliver());
        orderDao.save(orderMapper.toEntity(order));
        return true;
    }

    @Override
    public List<OrderVo> findOrdersByUser(Long userId) {

        List<OrderVo> ret = orderMapper.toVo(orderDao.findByUserId(userId));

        return ret;
    }

    @Override
    public DeliverVo getLaziestDeliver() {
        try {
            return deliverMapper.toVo(
                    deliverDao.findAll()
                            .stream().sorted((s1, s2) -> s1.getModDate().compareTo(s2.getModDate())).findFirst().get());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public List<OrderVo> getAllOrder() {
        return orderMapper.toVo(orderDao.findAll());
    }
}
