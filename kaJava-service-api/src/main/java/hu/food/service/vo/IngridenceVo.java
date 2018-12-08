package hu.food.service.vo;

public class IngridenceVo extends BaseVo {

	private String name;

	private Long price;

	public IngridenceVo() {
	}

	public IngridenceVo(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
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
	
}
