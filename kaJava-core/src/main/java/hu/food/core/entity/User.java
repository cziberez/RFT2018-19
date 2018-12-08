package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;
import hu.food.core.entity.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "USER_IDGEN", sequenceName = "S_USER")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "USER_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    private RoleEnum role;

    @OneToOne(cascade=CascadeType.ALL)
    private Address userAddress;

    public User() {
    }

    public User(String username, String firstname, String lastname, String password, String email, String phoneNumber, RoleEnum userRole, RoleEnum role, Address userAddress) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userAddress = userAddress;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
