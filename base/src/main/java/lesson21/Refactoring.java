package lesson21;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class Refactoring {

    private String name;
    private String color;
    private BigDecimal price;
    private int size;

    public Refactoring(String name, String color, BigDecimal price, int size) {

        print();
    }

    public void print() {
        System.out.println("Вызвалась печать");
    }

    public String getValue() {
        return "Здесь пробный текст";
    }
}
