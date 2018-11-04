package hu.food.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.food.core.dao.OrderDao;
import hu.food.core.entity.Order;

public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Order entity) {
		entityManager.persist(entity);
	}

	@Override
	public Order findById(Long id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public List<Order> findAll() {
		TypedQuery<Order> typedQuery = entityManager.createQuery("select o from Order o", Order.class);

		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Order entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Order entity) {
		entityManager.merge(entity);
	}

}
