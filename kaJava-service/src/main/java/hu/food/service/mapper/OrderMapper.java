package hu.food.service.mapper;

import hu.food.core.entity.Order;
import hu.food.service.vo.OrderVo;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
@Default
public class OrderMapper extends GenericMapper<Order, OrderVo>{

	private static final long serialVersionUID = 1L;

	public OrderMapper(Class<OrderVo> voClazz, Class<Order> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public OrderMapper() {
		super(OrderVo.class, Order.class);
	}

}
