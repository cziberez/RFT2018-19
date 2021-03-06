package hu.food.service.impl;

import hu.food.core.dao.AddressDao;
import hu.food.core.dao.UserDao;
import hu.food.core.entity.Address;
import hu.food.core.entity.User;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.UserService;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;
import java.util.stream.Collectors;

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

        User user = userMapper.toEntity(vo);

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
    public UserVo authenticateUser(String username, String password) {
        User userE = userDao.findUserByNameAndPassword(username,password);
        if (userE != null) {
            AddressVo addressVo = addressMapper.toVo(addressDao.find(userE.getUserAddress().getId()));
            UserVo userVo = userMapper.toVo(userE);
            userVo.setAddressVo(addressVo);
            return userVo;
        } else {
            return null;
        }
    }

    @Override
    public void modifyAddress(UserVo userVo) {
        addressDao.update(addressMapper.toEntity(userVo.getAddressVo()));
    }

    @Override
    public boolean isUniqueUser(UserVo userVo) {

        return userDao.findAll().stream()
                .filter(f -> f.getEmail() == userVo.getEmail() && f.getUsername() == userVo.getUsername())
                .collect(Collectors.toList()).isEmpty();
    }

}
