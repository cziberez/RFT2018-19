package hu.food.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import hu.food.core.dao.impl.OrderDaoImpl;
import hu.food.core.entity.Order;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.OrderMapper;
import hu.food.service.services.OrderService;
import hu.food.service.vo.OrderVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Default
@Dependent
public class OrderServiceImpl implements OrderService {

	@Default
	private OrderDaoImpl orderDao;

	@Default
	private OrderMapper mapper;

	@Override
	public void save(OrderVo vo) {
		orderDao.save(mapper.toEntity(vo));
	}

	@Override
	public void saveAll(List<OrderVo> voList) {
		voList.stream().forEach(fe -> orderDao.save(mapper.toEntity(fe)));
	}

	@Override
	public OrderVo find(Long id) {

		return mapper.toVo(orderDao.findById(id));
	}

	@Override
	public List<OrderVo> findAll() {

		return mapper.toVo(orderDao.findAll());
	}

	@Override
	public void setDeleted(OrderVo vo) {
		Order order = mapper.toEntity(vo);

		order.setStatus(StatusEnum.DELETED);

		orderDao.setDeleted(order);
	}

	@Override
	public void setActive(OrderVo vo) {
		Order order = mapper.toEntity(vo);

		order.setStatus(StatusEnum.ACTIVE);

		orderDao.setDeleted(order);
	}

}
