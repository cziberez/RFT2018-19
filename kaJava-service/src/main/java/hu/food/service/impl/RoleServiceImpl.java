package hu.food.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import hu.food.core.dao.impl.RoleDaoImpl;
import hu.food.core.entity.Role;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.RoleMapper;
import hu.food.service.services.RoleService;
import hu.food.service.vo.RoleVo;

@Stateless
public class RoleServiceImpl implements RoleService {

	@Default
	private RoleDaoImpl roleDao;

	@Default
	private RoleMapper mapper;

	@Override
	public void save(RoleVo vo) {
		roleDao.save(mapper.toEntity(vo));
	}

	@Override
	public void saveAll(List<RoleVo> voList) {
		voList.stream().forEach(fe -> roleDao.save(mapper.toEntity(fe)));
	}

	@Override
	public RoleVo find(Long id) {

		return mapper.toVo(roleDao.findById(id));
	}

	@Override
	public List<RoleVo> findAll() {

		return mapper.toVo(roleDao.findAll());
	}

	@Override
	public void setDeleted(RoleVo vo) {
		Role role = mapper.toEntity(vo);

		role.setStatus(StatusEnum.DELETED);

		roleDao.setDeleted(role);
	}

	@Override
	public void setActive(RoleVo vo) {
		Role role = mapper.toEntity(vo);

		role.setStatus(StatusEnum.ACTIVE);

		roleDao.setDeleted(role);
	}

}
