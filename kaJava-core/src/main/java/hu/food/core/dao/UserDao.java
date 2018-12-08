package hu.food.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.food.core.entity.User;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserDao implements BaseDao<User> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(User entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public User find(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void update(User entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> typedQuery = entityManager.createQuery("select a from User a", User.class);
		return typedQuery.getResultList();
	}

	public User findUserByName(String name){
		TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where  u.username = :name", User.class);

		try {
			return typedQuery.setParameter("name", name).getSingleResult();
		} catch (NoResultException e){
			return null;
		}
	}

}
