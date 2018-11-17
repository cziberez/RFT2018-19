package hu.food.service.services;

import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

import java.io.Serializable;

public interface UserService extends BaseService<UserVo>, Serializable {

    public void saveNewUser(UserVo user, AddressVo address);

}
