package hu.food.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import hu.food.core.dao.impl.IngridenceDaoImpl;
import hu.food.core.entity.Ingridence;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.IngridenceMapper;
import hu.food.service.services.IngridenceService;
import hu.food.service.vo.IngridenceVo;

@Stateless
public class IngridenceServiceImpl implements IngridenceService {

	@Default
	private IngridenceDaoImpl ingridenceDao;

	@Default
	private IngridenceMapper mapper;

	@Override
	public void save(IngridenceVo vo) {
		ingridenceDao.save(mapper.toEntity(vo));
	}

	@Override
	public void saveAll(List<IngridenceVo> voList) {
		voList.stream().forEach(fe -> ingridenceDao.save(mapper.toEntity(fe)));
	}

	@Override
	public IngridenceVo find(Long id) {

		return mapper.toVo(ingridenceDao.findById(id));
	}

	@Override
	public List<IngridenceVo> findAll() {

		return mapper.toVo(ingridenceDao.findAll());
	}

	@Override
	public void setDeleted(IngridenceVo vo) {
		Ingridence ingridence = mapper.toEntity(vo);

		ingridence.setStatus(StatusEnum.DELETED);

		ingridenceDao.setDeleted(ingridence);

	}

	@Override
	public void setActive(IngridenceVo vo) {
		Ingridence ingridence = mapper.toEntity(vo);

		ingridence.setStatus(StatusEnum.ACTIVE);

		ingridenceDao.setDeleted(ingridence);
	}

}
