package hu.food.core.dao;

import java.util.List;

import hu.food.core.entity.base.BaseEntity;

public interface BaseDao<E extends BaseEntity>{
	
	public void save(E entity);
	
	public void setActive(E entity);
	
	public void setDeleted(E entity);
	
	public E findById(Long id);
	
	public List<E> findAll();

}
