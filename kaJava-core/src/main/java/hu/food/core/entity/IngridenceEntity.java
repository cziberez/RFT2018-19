package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IngridenceEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Long price;
}
