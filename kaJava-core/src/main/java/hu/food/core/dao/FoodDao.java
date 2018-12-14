package hu.food.core.dao;

import hu.food.core.entity.Food;
import hu.food.core.entity.enums.StatusEnum;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FoodDao implements BaseDao<Food> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Food entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public Food find(Long id) {
        return entityManager.find(Food.class, id);
    }

    @Override
    public void update(Food entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(find(id));
    }

    @Override
    public List<Food> findAll() {
        TypedQuery<Food> typedQuery = entityManager.createQuery("select f from Food f", Food.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Food> findAllActive() {
        TypedQuery<Food> typedQuery = entityManager.createQuery("select f from Food f where f.status = hu.food.core.entity.enums.StatusEnum.ACTIVE", Food.class);
        return typedQuery.getResultList();
    }

    @Override
    public void removeLogical(Long id) {
        Food food = (Food) entityManager.find(Food.class, id);
        if (food != null) {
            food.setStatus(StatusEnum.DELETED);
        }
    }
}
