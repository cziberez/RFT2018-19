package hu.food.service.mapper;

import hu.food.core.entity.Address;
import hu.food.service.vo.AddressVo;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
@Default
public class AddressMapper extends GenericMapper<Address, AddressVo>{

	private static final long serialVersionUID = 1L;

	public AddressMapper(Class<AddressVo> voClazz, Class<Address> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public AddressMapper() {
		super(AddressVo.class, Address.class);
	}
}
