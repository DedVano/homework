package lesson19.dto;

import lesson19.DefaultValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Car implements Moveable, IVehicle {

    private final String mark;
    private final String model;
    private final double width;
    private final double height;

    public Car() {
        this("NoName", "NoName", -1d, -1d);
    }

    @Override
    public void move() {
        System.out.printf("Находится в движении автомобиль %s %s\n", mark, model);
    }

    private String getMarkAndModel(@DefaultValue("25") Integer digit) {
        return String.format("%s %s %d", mark, model, digit);
    }

    @DefaultValue("1.2")
    public double getHeight() {return height;}
}
