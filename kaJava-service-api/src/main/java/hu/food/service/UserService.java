package hu.food.service;

import java.util.List;

import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

public interface UserService {

	Long addUser(UserVo vo);

	void removeUser(Long id);

	List<UserVo> getAllUsers();
	
	void saveNewUser(UserVo user, AddressVo address);

}
