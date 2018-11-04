package hu.food.service.vo;

public class FoodImageVo extends BaseVo {

	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public FoodImageVo(byte[] image) {
		super();
		this.image = image;
	}

	public FoodImageVo() {
		
	}
}
