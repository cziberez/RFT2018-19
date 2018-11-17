package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;
import hu.food.core.entity.enums.RoleEnum;

import javax.persistence.*;


@Table(name = "ROLE")
@SequenceGenerator(name = "ROLE_IDGEN", sequenceName = "S_ROLE")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "ROLE_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ROLENAME")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    public Role() {
    }

    public Role(RoleEnum roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }
}
