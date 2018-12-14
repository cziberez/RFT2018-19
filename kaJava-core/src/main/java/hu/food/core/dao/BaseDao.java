package hu.food.core.dao;

import java.util.List;

import hu.food.core.entity.base.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	Long save(E entity);

	E find(Long id);

	void update(E entity);

	void remove(Long id);

	List<E> findAll();

	List<E> findAllActive();

	void removeLogical(Long id);

}
