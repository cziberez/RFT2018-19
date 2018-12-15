package hu.food.service.mapper;

import hu.food.core.entity.Address;
import hu.food.core.entity.DailyMenu;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.DailyMenuVo;

public class DailyMenuMapper extends GenericMapper<DailyMenu, DailyMenuVo> {

	private static final long serialVersionUID = 1L;

	private DailyMenuMapper(Class<DailyMenuVo> voClazz, Class<DailyMenu> entityClazz) {
		super(voClazz, entityClazz);
	}

	public DailyMenuMapper() {
		super(DailyMenuVo.class, DailyMenu.class);
	}

}
