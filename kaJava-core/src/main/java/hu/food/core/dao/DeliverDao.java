package hu.food.core.dao;

import hu.food.core.entity.Deliver;

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
public class DeliverDao implements BaseDao<Deliver> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Deliver entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public Deliver find(Long id) {
        return entityManager.find(Deliver.class, id);
    }

    @Override
    public void update(Deliver entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(find(id));
    }

    @Override
    public List<Deliver> findAll() {
        TypedQuery<Deliver> typedQuery = entityManager.createQuery("select d from Deliver d", Deliver.class);
        return typedQuery.getResultList();
    }
}
