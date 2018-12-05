package hu.food.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.management.relation.Role;

import hu.food.core.dao.UserDao;
import hu.food.core.entity.User;
import hu.food.service.UserServiceLocal;
import hu.food.service.UserServiceRemote;
import hu.food.service.mapper.UserMapper;
import hu.food.service.vo.RoleVo;
import hu.food.service.vo.UserVo;

@Stateless
@Local(UserServiceLocal.class)
@Remote(UserServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {

	@EJB
	private UserDao userDao;

	private UserMapper userMapper;

	@PostConstruct
	public void init() {
		userMapper = new UserMapper();
	}

	@Override
	public Long addUser(UserVo vo) {
		return userDao.save(userMapper.toEntity(vo));
	}

	@Override
	public void addRoleToUser(UserVo user, RoleVo role) {
		User userEntity = userMapper.toEntity(user);
		List<Role> roles = userEntity.getRoles();
		if (roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(rolemapper.toEntity(role));

		userDao.update(userEntity);

	}

	@Override
	public void removeRoleFromUser(UserVo user, RoleVo role) {
		User userEntity = userMapper.toEntity(user);
		List<Role> roles = userEntity.getRoles();

		roles.remove(rolemapper.toEntity(role));

		userDao.update(userEntity);

	}

	@Override
	public void removeUser(Long id) {
		userDao.remove(id);

	}

	@Override
	public List<UserVo> getAllUsers() {
		return userMapper.toVo(userDao.findAll());
	}

}
