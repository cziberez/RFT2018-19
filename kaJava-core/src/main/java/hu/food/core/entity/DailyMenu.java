package hu.food.core.entity;


import hu.food.core.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DAILYMENU")
@SequenceGenerator(name = "DAILYMENU_IDGEN", sequenceName = "S_DAILYMENU")
public class DailyMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "DAILYMENU_IDGEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Food mainDishes;

    @ManyToOne
    private Food soup;

    private String day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getMainDishes() {
        return mainDishes;
    }

    public void setMainDishes(Food mainDishes) {
        this.mainDishes = mainDishes;
    }

    public Food getSoup() {
        return soup;
    }

    public void setSoup(Food soup) {
        this.soup = soup;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
