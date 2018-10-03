package hu.food.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum PaymentType {

    CARD("Bankártya", "Credit card"),
    CASH("Készpénz", "Cash"),
    OTHER;
    private String neve;
    private String name;
}
