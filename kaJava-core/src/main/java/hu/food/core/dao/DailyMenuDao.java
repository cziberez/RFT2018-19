package hu.food.core.dao;

import hu.food.core.entity.DailyMenu;
import hu.food.core.entity.Deliver;
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
public class DailyMenuDao implements BaseDao<DailyMenu> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(DailyMenu entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public DailyMenu find(Long id) {
        return entityManager.find(DailyMenu.class, id);
    }

    @Override
    public void update(DailyMenu entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(find(id));
    }

    @Override
    public List<DailyMenu> findAll() {
        TypedQuery<DailyMenu> typedQuery = entityManager.createQuery("select d from DailyMenu d", DailyMenu.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<DailyMenu> findAllActive() {
        TypedQuery<DailyMenu> typedQuery = entityManager.createQuery("select d from DailyMenu d where d.status=hu.food.core.entity.enums.StatusEnum.DELETED", DailyMenu.class);
        return typedQuery.getResultList();
    }

    @Override
    public void removeLogical(Long id) {
        DailyMenu dailyMenu = (DailyMenu) entityManager.find(DailyMenu.class, id);
        if (dailyMenu != null) {
            dailyMenu.setStatus(StatusEnum.DELETED);
        }
    }

    public DailyMenu getDailyMenu(String day) {
        try {
            TypedQuery<DailyMenu> typedQuery = entityManager.createQuery("select d from DailyMenu d where d.day = :day", DailyMenu.class);
            return typedQuery.setParameter("day", day).getSingleResult();
        } catch (
                NoResultException e) {
            return null;
        }
    }
}
