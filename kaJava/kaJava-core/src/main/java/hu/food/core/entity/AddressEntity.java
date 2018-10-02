package hu.food.core.entity;

import javax.persistence.Entity;

@Entity
public class AddressEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Long postCode;
	
	private String city;
	
	private String street;
	
	private String houseNumber;
	
	private String floor;
	
	private String door;

	public Long getPostCode() {
		return postCode;
	}

	public void setPostCode(Long postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}
	
}
