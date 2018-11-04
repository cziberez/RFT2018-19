package hu.food.service.mapper;

import hu.food.core.entity.Role;
import hu.food.service.vo.RoleVo;

public class RoleMapper extends GenericMapper<Role, RoleVo>{

	private static final long serialVersionUID = 1L;
	
	public RoleMapper(Class<RoleVo> voClazz, Class<Role> entityClazz) {
		super(voClazz, entityClazz);
	}

	public RoleMapper() {
		super(RoleVo.class, Role.class);
	}

}
