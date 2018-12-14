package hu.food.core.dao;

import hu.food.core.entity.User;
import hu.food.core.entity.enums.StatusEnum;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<User> findAllActive() {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.status=hu.food.core.entity.enums.StatusEnum.ACTIVE", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void removeLogical(Long id) {
        User user = (User) entityManager.find(User.class, id);
        if (user != null) {
            user.setStatus(StatusEnum.DELETED);
        }
    }

    public User findUserByNameAndPassword(String name, String password) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where  u.username = :name and u.password = :password", User.class);

        try {
            return typedQuery.setParameter("name", name).setParameter("password", password).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
