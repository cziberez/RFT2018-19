package hu.food.service.impl;

import hu.food.core.dao.impl.UserDaoImpl;
import hu.food.core.entity.User;
import hu.food.core.entity.enums.StatusEnum;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.UserService;
import hu.food.service.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Getter
@Setter
@Transactional(Transactional.TxType.REQUIRED)
@Named("userService")
public class UserServiceImpl implements UserService {

    @Inject
    private UserDaoImpl userDao;

    @Inject
    private UserMapper mapper;

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

}
