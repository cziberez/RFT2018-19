package hu.food.service.vo;

import hu.food.service.enums.Roles;

public class RoleVo extends BaseVo {

	private String name;

	private Roles role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public RoleVo(String name, Roles role) {
		super();
		this.name = name;
		this.role = role;
	}

	public RoleVo() {
		super();
	}

}
