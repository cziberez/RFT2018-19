package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FOOD")
@SequenceGenerator(name = "FOOD_IDGEN", sequenceName = "S_FOOD")
public class Food extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "FOOD_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PICTUREURL")
    private String pictureUrl;

    @OneToOne
    private FoodImage foodImage;

    @ManyToMany
    private List<Ingridence> ingridence;

    public Food() {
    }

    public Food(Long id, String name, Long price, String description, String category, String pictureUrl, FoodImage foodImage, List<Ingridence> ingridence) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.pictureUrl = pictureUrl;
        this.foodImage = foodImage;
        this.ingridence = ingridence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodImage getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(FoodImage foodImage) {
        this.foodImage = foodImage;
    }

    public List<Ingridence> getIngridence() {
        return ingridence;
    }

    public void setIngridence(List<Ingridence> ingridence) {
        this.ingridence = ingridence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
