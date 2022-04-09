package lesson11.homework.carClasses;

public class Truck extends AllCars {
    public Truck(int speed, double weightInTons, double width, double length, double height) {
        super(speed, weightInTons, width, length, height);
    }

    public Truck(String numberPlate, int speed, double weightInTons, double width, double length, double height) {
        super(numberPlate, speed, weightInTons, width, length, height);
    }

    public Truck() {
        super(speedGenerate(), weightGenerate(), widthGenerate(), lengthGenerate(), heightGenerate());
    }


    static int speedGenerate() {
        return (int) (40 + Math.round(Math.random() * 70));
    }

    static double weightGenerate() {
        return 5 + Math.round(Math.random() * 10);
    }

    static double widthGenerate() {
        return 2 + Math.round(Math.random() * 30) / 10;
    }

    static double lengthGenerate() {
        return 6 + Math.round(Math.random() * 30) / 10;
    }

    static double heightGenerate() {
        return 3 + Math.round(Math.random() * 30) / 10;
    }
}
