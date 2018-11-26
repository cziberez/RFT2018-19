package hu.food.core.dao.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hu.food.core.dao.FoodDao;
import hu.food.core.entity.Food;

@Default
@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class FoodDaoImpl implements FoodDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Food entity) {
		entityManager.persist(entity);
	}

	@Override
	public Food findById(Long id) {
		return entityManager.find(Food.class, id);
	}

	@Override
	public List<Food> findAll() {
		TypedQuery<Food> typedQuery = entityManager.createQuery("select f from Food f", Food.class);

		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Food entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Food entity) {
		entityManager.merge(entity);
	}

}
