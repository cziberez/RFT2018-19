package hu.food.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.food.core.dao.DeliverDao;
import hu.food.core.entity.Deliver;

public class DeliverDaoImpl implements DeliverDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Deliver entity) {
		entityManager.persist(entity);
	}

	@Override
	public Deliver findById(Long id) {
		return entityManager.find(Deliver.class, id);
	}

	@Override
	public List<Deliver> findAll() {
		TypedQuery<Deliver> typedQuery = entityManager.createQuery("select d from Deliver d", Deliver.class);
		
		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Deliver entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Deliver entity) {
		entityManager.merge(entity);
	}

}
