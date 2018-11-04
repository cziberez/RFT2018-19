package hu.food.service.mapper;

import hu.food.core.entity.Ingridence;
import hu.food.service.vo.IngridenceVo;

public class IngridenceMapper extends GenericMapper<Ingridence, IngridenceVo>{

	private static final long serialVersionUID = 1L;

	public IngridenceMapper(Class<IngridenceVo> voClazz, Class<Ingridence> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public IngridenceMapper() {
		super(IngridenceVo.class, Ingridence.class);
	}
}
