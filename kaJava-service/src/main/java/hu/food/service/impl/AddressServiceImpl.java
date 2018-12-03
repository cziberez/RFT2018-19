package hu.food.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import hu.food.core.dao.impl.AddressDaoImpl;
import hu.food.core.entity.Address;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.services.AddressService;
import hu.food.service.vo.AddressVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Default
@Dependent
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
