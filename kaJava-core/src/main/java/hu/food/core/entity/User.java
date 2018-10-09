package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    private String phoneNumber;

    @OneToOne
    private Address userAddress;

    @ManyToOne
    private Role userRole;
}
