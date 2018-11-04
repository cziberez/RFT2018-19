package hu.food.service.services;

import java.util.List;

public interface BaseService<T>{
	
	public void save(T vo);

	public void setDeleted(T vo);
	
	public void saveAll(List<T> voList);
	
	public void setActive(T vo);
	
	public T find(Long id);
	
	public List<T> findAll();
	
}
