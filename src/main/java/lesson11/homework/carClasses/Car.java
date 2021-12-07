package lesson11.homework.carClasses;

public class Car extends AllCars {

    public Car(int speed, double weightInTons, double width, double length, double height) {
        super(speed, weightInTons, width, length, height);
    }

    public Car(String numberPlate, int speed, double weightInTons, double width, double length, double height) {
        super(numberPlate, speed, weightInTons, width, length, height);
    }

    public Car() {
        super(speedGenerate(), weightGenerate(), widthGenerate(), lengthGenerate(), heightGenerate());
    }


    static int speedGenerate() {
        return (int) (50 + Math.round(Math.random() * 60));
    }

    static double weightGenerate() {
        return 1.5 + Math.round(Math.random() * 20) / 10;
    }

    static double widthGenerate() {
        return 2 + Math.round(Math.random() * 10) / 10;
    }

    static double lengthGenerate() {
        return 3.5 + Math.round(Math.random() * 10) / 10;
    }

    static double heightGenerate() {
        return 2 + Math.round(Math.random() * 5) / 10;
    }
}
