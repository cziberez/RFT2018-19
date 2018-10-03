package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Long price;

    @Lob
    private String description;

    @OneToOne
    private FoodImageEntity foodImage;

    @ManyToMany
    private List<IngridenceEntity> ingridence;
}
