package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private Long postCode;
    private String city;
    private String street;
    private String houseNumber;
    private String floor;
    private String door;

}
