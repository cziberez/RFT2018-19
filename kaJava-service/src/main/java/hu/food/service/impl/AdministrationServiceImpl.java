package hu.food.service.impl;

import hu.food.core.dao.UserDao;
import hu.food.service.enums.Role;
import hu.food.service.mapper.UserMapper;
import hu.food.service.services.AdministrationService;
import hu.food.service.vo.UserVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AdministrationServiceImpl implements AdministrationService {

    @EJB
    private UserDao userDao;

    private UserMapper userMapper;

    @PostConstruct
    public void init() {
        userMapper = new UserMapper();
    }

    @Override
    public void giveRoleToUser(UserVo user, Role role) {
        user.setRole(role);

        userDao.update(userMapper.toEntity(user));

    }
}
