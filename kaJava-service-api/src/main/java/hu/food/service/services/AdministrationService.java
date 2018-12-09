package hu.food.service.services;

import hu.food.service.enums.Role;
import hu.food.service.vo.UserVo;

public interface AdministrationService {

    void giveRoleToUser(UserVo user, Role role);
}
