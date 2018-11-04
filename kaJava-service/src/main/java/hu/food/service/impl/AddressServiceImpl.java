package hu.food.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import hu.food.core.dao.impl.AddressDaoImpl;
import hu.food.core.entity.Address;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.services.AddressService;
import hu.food.service.vo.AddressVo;

@Stateless
public class AddressServiceImpl implements AddressService{
	
	@Default
	private AddressDaoImpl addressDao;
	
	@Default
	private AddressMapper mapper;
	
	@Override
	public void save(AddressVo vo) {
		addressDao.save(mapper.toEntity(vo));
	}

	@Override
	public void saveAll(List<AddressVo> voList) {
		voList.stream().forEach(fe -> addressDao.save(mapper.toEntity(fe)));
	}

	@Override
	public AddressVo find(Long id) {
		
		return mapper.toVo(addressDao.findById(id));
	}

	@Override
	public List<AddressVo> findAll() {
	
		return mapper.toVo(addressDao.findAll());
	}

	@Override
	public void setDeleted(AddressVo vo) {
		Address address = mapper.toEntity(vo);
		
		address.setStatus(StatusEnum.DELETED);
		
		addressDao.setDeleted(address);
	}

	@Override
	public void setActive(AddressVo vo) {
		Address address = mapper.toEntity(vo);
		
		address.setStatus(StatusEnum.ACTIVE);
		
		addressDao.setDeleted(address);
	}

}
