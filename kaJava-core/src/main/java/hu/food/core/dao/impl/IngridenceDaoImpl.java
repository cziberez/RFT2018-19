package hu.food.core.dao.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hu.food.core.dao.IngridenceDao;
import hu.food.core.entity.Ingridence;

@Default
@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class IngridenceDaoImpl implements IngridenceDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Ingridence entity) {
		entityManager.persist(entity);
	}

	@Override
	public Ingridence findById(Long id) {
		return entityManager.find(Ingridence.class, id);
	}

	@Override
	public List<Ingridence> findAll() {
		TypedQuery<Ingridence> typedQuery = entityManager.createQuery("select d from Ingridence d", Ingridence.class);
		
		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Ingridence entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Ingridence entity) {
		entityManager.merge(entity);
	}
}
