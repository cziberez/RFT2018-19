package hu.food.core.dao.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hu.food.core.dao.AddressDao;
import hu.food.core.entity.Address;


@Default
@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class AddressDaoImpl implements AddressDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Address entity) {
		
		entityManager.persist(entity);
	}

	@Override
	public Address findById(Long id) {
		
		return entityManager.find(Address.class, id);
	}

	@Override
	public List<Address> findAll() {
		
		TypedQuery<Address> typedQuery = entityManager.createQuery("select a from Address a", Address.class);
		
		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Address entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Address entity) {
		entityManager.merge(entity);
	}

}
