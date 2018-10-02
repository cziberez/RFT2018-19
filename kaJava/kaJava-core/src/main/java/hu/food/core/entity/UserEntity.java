package hu.food.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToOne
	private AddressEntity userAddress;
	
	@ManyToOne
	private RoleEntity userRole;

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

	public AddressEntity getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(AddressEntity userAddress) {
		this.userAddress = userAddress;
	}

	public RoleEntity getUserRole() {
		return userRole;
	}

	public void setUserRole(RoleEntity userRole) {
		this.userRole = userRole;
	}

}
