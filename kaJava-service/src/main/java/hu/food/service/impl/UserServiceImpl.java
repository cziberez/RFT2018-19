package hu.food.service.impl;

import hu.food.core.dao.AddressDao;
import hu.food.core.dao.UserDao;
import hu.food.core.entity.Address;
import hu.food.core.entity.User;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.AddressMapper;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.UserService;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Default
@Dependent
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;

	@Inject
    private UserDao userDao;

    @Inject
    private AddressDao addressDao;

    @Inject
    private UserMapper mapper;

    @Inject
    private AddressMapper addressMapper;

    @Override
    public void save(UserVo vo) {
        userDao.save(mapper.toEntity(vo));
    }

    @Override
    public void saveAll(List<UserVo> voList) {
        voList.stream().forEach(fe -> userDao.save(mapper.toEntity(fe)));
    }

    @Override
    public UserVo find(Long id) {

        return mapper.toVo(userDao.findById(id));
    }

    @Override
    public List<UserVo> findAll() {

        return mapper.toVo(userDao.findAll());
    }

    @Override
    public void setDeleted(UserVo vo) {
        User user = mapper.toEntity(vo);

        user.setStatus(StatusEnum.DELETED);

        userDao.setDeleted(user);
    }

    @Override
    public void setActive(UserVo vo) {
        User user = mapper.toEntity(vo);

        user.setStatus(StatusEnum.ACTIVE);

        userDao.setDeleted(user);
    }

    @Override
    public void saveNewUser(UserVo userVo, AddressVo addressVo) {
        Address address = new Address();

        address = addressMapper.toEntity(addressVo);

        addressDao.save(address);

        User user = new User();

        user = mapper.toEntity(userVo);

        user.setUserAddress(address);

        userDao.save(user);
    }
}
