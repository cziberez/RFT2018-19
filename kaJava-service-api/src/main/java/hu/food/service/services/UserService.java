package hu.food.service.services;

import java.util.List;

import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

public interface UserService {

	Long addUser(UserVo vo);

	void removeUser(Long id);

	List<UserVo> getAllUsers();

	UserVo authenticateUser(String username,String password);

	void modifyAddress(UserVo userVo);

	boolean isUniqueUser(UserVo userVo);
}
