package hu.food.core.dao.impl;

import hu.food.core.dao.UserDao;
import hu.food.core.entity.User;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Default
@Dependent
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);

        return typedQuery.getResultList();
    }

    @Override
    public void setActive(User entity) {
        entityManager.merge(entity);
    }

    @Override
    public void setDeleted(User entity) {
        entityManager.merge(entity);
    }

}
