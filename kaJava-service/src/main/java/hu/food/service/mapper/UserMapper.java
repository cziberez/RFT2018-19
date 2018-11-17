package hu.food.service.mapper;

import hu.food.core.entity.User;
import hu.food.service.vo.UserVo;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
@Default
public class UserMapper extends GenericMapper<User, UserVo>{

	private static final long serialVersionUID = 4698938549156357714L;
	
	public UserMapper(Class<UserVo> voClazz, Class<User> entityClazz) {
		super(voClazz, entityClazz);
	}
	
	public UserMapper() {
		super(UserVo.class, User.class);
	}
	
}
