package hu.food.core.entity;

public class IngridenceEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Long price;

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
	
}
