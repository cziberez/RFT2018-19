package hu.food.core.entity;

import javax.persistence.Entity;

@Entity
public class RoleEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
