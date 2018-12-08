package hu.food.service.vo;

public class DeliverVo extends BaseVo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeliverVo(String name) {
		super();
		this.name = name;
	}

	public DeliverVo() {
		
	}

}
