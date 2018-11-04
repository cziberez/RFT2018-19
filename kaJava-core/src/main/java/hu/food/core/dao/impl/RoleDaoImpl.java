package hu.food.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.food.core.dao.RoleDao;
import hu.food.core.entity.Role;

public class RoleDaoImpl implements RoleDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Role entity) {
		entityManager.persist(entity);
	}

	@Override
	public Role findById(Long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r", Role.class);

		return typedQuery.getResultList();
	}

	@Override
	public void setActive(Role entity) {
		entityManager.merge(entity);
	}

	@Override
	public void setDeleted(Role entity) {
		entityManager.merge(entity);
	}

}
