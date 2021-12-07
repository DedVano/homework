package lesson11.homework;

import lesson11.homework.carClasses.AllCars;
import lesson11.homework.carClasses.Car;
import lesson11.homework.carClasses.Truck;
import lesson11.homework.enumerations.ExceptionReasons;
import lesson11.homework.exceptionClasses.MyException;

import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {
        AllCars[] cars = new AllCars[30];
        for (int eachCar = 0; eachCar < cars.length; eachCar++) {
            cars[eachCar] = Math.round(Math.random() * 3) == 1 ? new Car() : new Truck();
        }

        System.out.print("""

                Требования к проезду КПП таковы:
                вес автомобиля не должен превышать 8 тонн;
                габариты автомобиля не должны превышать 4 м высоты и 2.5 м ширины;
                скорость автомобиля не должна превышать 80 км/ч; за скорость более 100 км/ч автомобиль будет арестован.
                """);

        IntStream.rangeClosed(1, 2).forEach(iteration -> {
            System.out.println("-------------------------------------------------------------------------------------" +
                    "--------------------------------");
            for (AllCars eachCar : cars) {
                try {
                    if (!eachCar.isUnderArrest()) {
                        System.out.print("""

                                В сторону КПП направляется следующий автомобиль:
                                """);
                        System.out.println(eachCar);
                        tryToPassCheckpoint(eachCar);
                        System.out.println(eachCar.getType() + " с номером " + eachCar.getNumberPlate() + " проехал КПП.");
                    } else
                        System.out.println("\n" + eachCar.getType() + " с номером " + eachCar.getNumberPlate() +
                                " арестован, поэтому КПП не пересекал.");
                } catch (MyException exception) {
                    switch (exception.getReason()) {
                        case SPEED -> System.out.println(exception.getType() + " с номером " + exception.getNumberPlate() +
                                " превысил скорость.");
                        case HIGHSPEED -> {
                            System.out.println(exception.getType() + " с номером " + exception.getNumberPlate() +
                                    " серьезно превысил скорость. Автомобиль арестован.");
                            eachCar.setUnderArrest(true);
                        }
                        case WIDTH -> System.out.println(exception.getType() + " с номером " + exception.getNumberPlate() +
                                " превышает допустимую ширину.");
                        case HEIGHT -> System.out.println(exception.getType() + " с номером " + exception.getNumberPlate() +
                                " превышает допустимую высоту.");
                        case WEIGHT -> System.out.println(exception.getType() + " с номером " + exception.getNumberPlate() +
                                " превышает допустимый вес.");
                    }
                }
            }
        });
    }

    static void tryToPassCheckpoint(AllCars car) throws MyException {
        if (car.getSpeed() > 80 && car.getSpeed() <= 100) {
            throw new MyException("Превышение допустимой скорости",
                    ExceptionReasons.SPEED, car.getType(), car.getNumberPlate());
        } else if (car.getSpeed() > 100) {
            throw new MyException("Серьезное превышение допустимой скорости. Автомобиль арестован.",
                    ExceptionReasons.HIGHSPEED, car.getType(), car.getNumberPlate());
        } else if (car.getWidth() > 2.5) {
            throw new MyException("Превышение допустимой ширины",
                    ExceptionReasons.WIDTH, car.getType(), car.getNumberPlate());
        } else if (car.getHeight() > 4) {
            throw new MyException("Превышение допустимой высоты",
                    ExceptionReasons.HEIGHT, car.getType(), car.getNumberPlate());
        } else if (car.getWeightInTons() > 8) {
            throw new MyException("Превышение допустимого веса",
                    ExceptionReasons.WEIGHT, car.getType(), car.getNumberPlate());
        }
    }
}
