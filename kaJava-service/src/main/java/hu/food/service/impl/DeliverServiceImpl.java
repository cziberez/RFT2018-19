package hu.food.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import hu.food.core.dao.impl.DeliverDaoImpl;
import hu.food.core.entity.Deliver;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.DeliverMapper;
import hu.food.service.services.DeliverService;
import hu.food.service.vo.DeliverVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Default
@Dependent
public class DeliverServiceImpl implements DeliverService {

	@Default
	private DeliverDaoImpl deliverDao;

	@Default
	private DeliverMapper mapper;

	@Override
	public void save(DeliverVo vo) {
		deliverDao.save(mapper.toEntity(vo));
	}


	@Override
	public void saveAll(List<DeliverVo> voList) {
		voList.stream().forEach(fe -> deliverDao.save(mapper.toEntity(fe)));
	}

	@Override
	public DeliverVo find(Long id) {

		return mapper.toVo(deliverDao.findById(id));
	}

	@Override
	public List<DeliverVo> findAll() {

		return mapper.toVo(deliverDao.findAll());
	}

	@Override
	public void setDeleted(DeliverVo vo) {
		Deliver deliver = mapper.toEntity(vo);
		
		deliver.setStatus(StatusEnum.DELETED);
		
		deliverDao.setDeleted(deliver);
		
	}

	@Override
	public void setActive(DeliverVo vo) {
		Deliver deliver = mapper.toEntity(vo);
		
		deliver.setStatus(StatusEnum.ACTIVE);
		
		deliverDao.setDeleted(deliver);
		
	}
}
