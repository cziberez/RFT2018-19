package hu.food.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class FoodEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Long price;
	
	@Lob
	private String description;
	
	@OneToOne
	private FoodImageEntity foodImage;
	
	@ManyToMany
	private List<IngridenceEntity> ingridence;

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

	public FoodImageEntity getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(FoodImageEntity foodImage) {
		this.foodImage = foodImage;
	}

	public List<IngridenceEntity> getIngridence() {
		return ingridence;
	}

	public void setIngridence(List<IngridenceEntity> ingridence) {
		this.ingridence = ingridence;
	}
	
}
