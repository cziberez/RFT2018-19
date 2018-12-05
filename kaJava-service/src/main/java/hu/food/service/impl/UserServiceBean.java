package hu.food.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import hu.food.core.dao.AddressDao;
import hu.food.core.dao.UserDao;
import hu.food.core.entity.User;
import hu.food.service.UserService;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.mapper.UserMapper;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceBean implements UserService {

	@EJB
	private UserDao userDao;

	@EJB
	private AddressDao addressDao;

	private UserMapper userMapper;

	private AddressMapper addressMapper;

	@PostConstruct
	public void init() {
		userMapper = new UserMapper();
		addressMapper = new AddressMapper();
	}

	@Override
	public Long addUser(UserVo vo) {
		return userDao.save(userMapper.toEntity(vo));
	}

	@Override
	public void removeUser(Long id) {
		userDao.remove(id);

	}

	@Override
	public List<UserVo> getAllUsers() {
		return userMapper.toVo(userDao.findAll());
	}

	@Override
	public void saveNewUser(UserVo user, AddressVo address) {
		addressDao.save(addressMapper.toEntity(address));

		User newUser = userMapper.toEntity(user);
		newUser.setUserAddress(addressMapper.toEntity(address));
		userDao.save(newUser);
	}

}
