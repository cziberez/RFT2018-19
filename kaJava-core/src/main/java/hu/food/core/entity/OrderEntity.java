package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long price;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Lob
    private String description;

    @ManyToMany
    private List<FoodEntity> orderedFood;

    @ManyToOne
    private UserEntity customer;

    @ManyToOne
    private DeliverEntity deliver;
}
