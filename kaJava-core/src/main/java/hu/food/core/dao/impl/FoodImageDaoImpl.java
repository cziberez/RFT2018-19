package hu.food.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.food.core.dao.FoodImageDao;
import hu.food.core.entity.FoodImage;

public class FoodImageDaoImpl implements FoodImageDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(FoodImage entity) {
		entityManager.persist(entity);
	}

	@Override
	public FoodImage findById(Long id) {
		return entityManager.find(FoodImage.class, id);
	}

	@Override
	public List<FoodImage> findAll() {
		TypedQuery<FoodImage> typedQuery = entityManager.createQuery("select d from FoodImage d", FoodImage.class);

		return typedQuery.getResultList();
	}

	@Override
	public void setActive(FoodImage entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(FoodImage entity) {
		entityManager.merge(entity);
	}

}
