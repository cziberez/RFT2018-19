package hu.food.core.entity;

import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DELIVER")
@SequenceGenerator(name = "DELIVER_IDGEN", sequenceName = "S_DELIVER")
public class Deliver extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DELIVER_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Deliver() {
    }

    public Deliver(String name) {
        this.name = name;
    }

    public Deliver(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
