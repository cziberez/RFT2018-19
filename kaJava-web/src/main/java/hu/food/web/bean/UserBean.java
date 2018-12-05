package hu.food.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import hu.food.service.UserService;
import hu.food.service.vo.AddressVo;
import hu.food.service.vo.UserVo;

@Named("userBean")
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserService userService;

	private List<UserVo> users;

	private UserVo user;

	private AddressVo address;

	@PostConstruct
	public void init() {
		users = userService.getAllUsers();
		user = new UserVo();
		setAddress(new AddressVo());
	}

	public void addUser() {
		userService.addUser(user);
	}
	
	public void SaveNewUser() {
		userService.saveNewUser(user, address);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public AddressVo getAddress() {
		return address;
	}

	public void setAddress(AddressVo address) {
		this.address = address;
	}

}
