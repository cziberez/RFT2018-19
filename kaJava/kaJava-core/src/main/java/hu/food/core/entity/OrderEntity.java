package hu.food.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrderEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Long price;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@Lob
	private String description;

	@ManyToMany
	private List<FoodEntity> orderedFood;

	@ManyToOne
	private UserEntity customer;
	
	@ManyToOne
	private DeliverEntity deliver;

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FoodEntity> getOrderedFood() {
		return orderedFood;
	}

	public void setOrderedFood(List<FoodEntity> orderedFood) {
		this.orderedFood = orderedFood;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public DeliverEntity getDeliver() {
		return deliver;
	}

	public void setDeliver(DeliverEntity deliver) {
		this.deliver = deliver;
	}
	
}
