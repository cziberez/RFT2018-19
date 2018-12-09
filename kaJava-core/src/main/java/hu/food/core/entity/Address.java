package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "ADDRESS_IDGEN", sequenceName = "S_ADDRESS")
public class Address extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "ADDRESS_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "POSTCODE")
    private String postCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSENUMBER")
    private String houseNumber;

    @Column(name = "FLOOR")
    private String floor;

    @Column(name = "DOOR")
    private String door;


    public Address() {
    }

    public Address(Long id, String postCode, String city, String street, String houseNumber, String floor, String door) {
        this.id = id;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.door = door;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
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
