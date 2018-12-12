package hu.food.service.vo;

import java.util.List;

public class FoodVo extends BaseVo {

	private String name;

	private Long price;

	private String description;

	private String category;

	private FoodImageVo foodImage;

	private String pictureUrl;

	private List<IngridenceVo> ingridence;

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

	public FoodImageVo getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(FoodImageVo foodImage) {
		this.foodImage = foodImage;
	}

	public List<IngridenceVo> getIngridence() {
		return ingridence;
	}

	public void setIngridence(List<IngridenceVo> ingridence) {
		this.ingridence = ingridence;
	}

	public FoodVo(String name, Long price, String description, FoodImageVo foodImage, String pictureUrl, List<IngridenceVo> ingridence) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.foodImage = foodImage;
		this.pictureUrl = pictureUrl;
		this.ingridence = ingridence;
	}

	public FoodVo() {

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
