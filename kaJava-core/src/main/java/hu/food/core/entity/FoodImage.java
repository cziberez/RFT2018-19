package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "FOODIMAGE")
@SequenceGenerator(name = "FOODIMAGE_IDGEN", sequenceName = "S_FOODIMAGE")
public class FoodImage extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "FOODIMAGE_IDGEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "IMAGE")
	@Lob
	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
