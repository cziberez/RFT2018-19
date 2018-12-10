package hu.food.service.impl;

import hu.food.core.dao.AddressDao;
import hu.food.core.dao.UserDao;
import hu.food.core.entity.Address;
import hu.food.core.entity.User;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

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

		Address address = new Address();

		addressDao.save(address);

		User  user = userMapper.toEntity(vo);

		user.setUserAddress(address);

		return userDao.save(user);
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
	public UserVo authenticateUser(String username) {
		return userMapper.toVo(userDao.findUserByName(username));
	}

	@Override
	public void modifyAddress(UserVo userVo) {
		addressDao.update(addressMapper.toEntity(userVo.getAddressVo()));

		userDao.update(userMapper.toEntity(userVo));
	}

}
