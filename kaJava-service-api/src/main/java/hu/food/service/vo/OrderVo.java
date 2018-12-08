package hu.food.service.vo;

import java.util.List;

import hu.food.service.enums.PaymentType;

public class OrderVo extends BaseVo {

	private Long price;

	private PaymentType paymentType;

	private String description;

	private List<FoodVo> orderedFood;

	private UserVo customer;

	private DeliverVo deliver;

	public OrderVo() {
	}

	public OrderVo(Long price, PaymentType paymentType, String description, List<FoodVo> orderedFood, UserVo customer,
			DeliverVo deliver) {
		super();
		this.price = price;
		this.paymentType = paymentType;
		this.description = description;
		this.orderedFood = orderedFood;
		this.customer = customer;
		this.deliver = deliver;
	}

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

	public List<FoodVo> getOrderedFood() {
		return orderedFood;
	}

	public void setOrderedFood(List<FoodVo> orderedFood) {
		this.orderedFood = orderedFood;
	}

	public UserVo getCustomer() {
		return customer;
	}

	public void setCustomer(UserVo customer) {
		this.customer = customer;
	}

	public DeliverVo getDeliver() {
		return deliver;
	}

	public void setDeliver(DeliverVo deliver) {
		this.deliver = deliver;
	}

}
