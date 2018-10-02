package hu.food.core.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class FoodImageEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Lob
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
