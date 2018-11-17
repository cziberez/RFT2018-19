package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "INGRIDENCE")
@SequenceGenerator(name = "INGRIDENCE_IDGEN", sequenceName = "S_INGRIDENCE")
public class Ingridence extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "INGRIDENCE_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Long price;

    public Ingridence() {
    }

    public Ingridence(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
