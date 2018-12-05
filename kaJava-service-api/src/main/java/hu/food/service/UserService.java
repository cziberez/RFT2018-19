package hu.food.service;

import java.util.List;

import hu.food.service.vo.RoleVo;
import hu.food.service.vo.UserVo;

public interface UserService {

	Long addUser(UserVo vo);

	void addRoleToUser(UserVo user, RoleVo role);

	void removeRoleFromUser(UserVo user, RoleVo role);

	void removeUser(Long id);

	List<UserVo> getAllUsers();

}
