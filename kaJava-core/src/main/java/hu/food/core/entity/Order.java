package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;
import hu.food.core.entity.enums.PaymentType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDER")
@SequenceGenerator(name = "ORDER_IDGEN", sequenceName = "S_ORDER")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDER_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "PAYMENTTYPE")
    private PaymentType paymentType;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    private List<Food> orderedFood;

    @ManyToOne
    private User customer;

    @ManyToOne
    private Deliver deliver;

    public Order() {
    }

    public Order(Long price, PaymentType paymentType, String description, List<Food> orderedFood, User customer, Deliver deliver) {
        this.price = price;
        this.paymentType = paymentType;
        this.description = description;
        this.orderedFood = orderedFood;
        this.customer = customer;
        this.deliver = deliver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Food> getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(List<Food> orderedFood) {
        this.orderedFood = orderedFood;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }
}
