package lesson9.homework;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AutomobileRunner {

    public static void main(String[] args) {

        Automobile[] automobiles = new Automobile[10];
        for (int eachCar = 0, index = 1; eachCar < automobiles.length; eachCar++, index++) {
            automobiles[eachCar] = Math.round(Math.random() * 3) == 1 ? new Car(index) : new Truck(index);
        }

        IntStream.rangeClosed(1, 6).forEach(iteration -> {
            Arrays.stream(automobiles).forEach(eachCar -> eachCar.move((int) (Math.round(Math.random() * 1000))));
            System.out.println();
        });
    }
}
