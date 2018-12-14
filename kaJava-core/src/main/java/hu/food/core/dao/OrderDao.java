package hu.food.core.dao;

import hu.food.core.entity.Order;
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
public class OrderDao implements BaseDao<Order> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Order entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public Order find(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void update(Order entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(find(id));
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> typedQuery = entityManager.createQuery("select o from Order o", Order.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Order> findAllActive() {
        TypedQuery<Order> typedQuery = entityManager.createQuery("select o from Order o where o.status=hu.food.core.entity.enums.StatusEnum.ACTIVE", Order.class);
        return typedQuery.getResultList();
    }

    @Override
    public void removeLogical(Long id) {
        Order order = (Order) entityManager.find(Order.class, id);
        if (order != null) {
            order.setStatus(StatusEnum.DELETED);
        }
    }

    public List<Order> findByUserId(Long userId) {
        TypedQuery<Order> typedQuery = entityManager.createQuery("select o from Order o where o.customer.id = :userId", Order.class);
        return typedQuery.setParameter("userId", userId).getResultList();
    }
}
