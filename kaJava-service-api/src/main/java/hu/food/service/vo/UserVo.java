package hu.food.service.vo;

import hu.food.service.enums.Roles;

public class UserVo extends BaseVo {

	private String username;

	private String firstname;

	private String lastname;

	private String password;

	private String email;

	private String phoneNumber;

	private AddressVo userAddress;

	private Roles userRole;

	public UserVo() {
	}

	public UserVo(String username, String firstname, String lastname, String password, String email, String phoneNumber,
			AddressVo userAddress, Roles userRole) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userAddress = userAddress;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressVo getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(AddressVo userAddress) {
		this.userAddress = userAddress;
	}

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

}
