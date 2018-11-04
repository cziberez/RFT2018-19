package hu.food.service.mapper;

import hu.food.core.entity.Deliver;
import hu.food.service.vo.DeliverVo;

public class DeliverMapper extends GenericMapper<Deliver, DeliverVo>{

	private static final long serialVersionUID = 1L;

	public DeliverMapper(Class<DeliverVo> voClazz, Class<Deliver> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public DeliverMapper() {
		super(DeliverVo.class, Deliver.class);
	}

}
