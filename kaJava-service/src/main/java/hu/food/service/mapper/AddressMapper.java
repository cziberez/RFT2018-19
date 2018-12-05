package hu.food.service.mapper;

import hu.food.core.entity.Address;
import hu.food.service.vo.AddressVo;

public class AddressMapper extends GenericMapper<Address, AddressVo> {

	private static final long serialVersionUID = 1L;

	private AddressMapper(Class<AddressVo> voClazz, Class<Address> entityClazz) {
		super(voClazz, entityClazz);
	}

	public AddressMapper() {
		super(AddressVo.class, Address.class);
	}

}
