package lesson11.homework.carClasses;


import lesson11.homework.enumerations.NumberplateLetters;
import lesson11.homework.enumerations.NumberplateRegions;

public class AllCars {

    final String numberPlate;
    int speed;
    double weightInTons;
    final double width;
    final double length;
    final double height;
    boolean underArrest = false;

    AllCars(int speed, double weightInTons, double width, double length, double height) {
        this.numberPlate = numberPlateGenerate();
        this.speed = speed;
        this.weightInTons = weightInTons;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    AllCars(String numberPlate, int speed, double weightInTons, double width, double length, double height) {
        this.numberPlate = numberPlate;
        this.speed = speed;
        this.weightInTons = weightInTons;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    private String numberPlateGenerate() {
        int[] digits = new int[3];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int) Math.floor(Math.random() * 10);
        }
        StringBuilder numbersString = new StringBuilder();
        for (int i : digits) {
            numbersString.append(i);
        }
        char[] letters = new char[3];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = NumberplateLetters.values()[(int) Math.floor(Math.random() *
                    (NumberplateLetters.values().length))].toString().charAt(0);
        }
        int region = NumberplateRegions.values()[(int)
                (Math.floor(Math.random() * NumberplateRegions.values().length))].getRegionValue();
        return letters[0] + numbersString.toString() + letters[1] + letters[2] + " " + region;
    }

    @Override
    public String toString() {
        String type = this.getClass().getSimpleName().equals("Car") ? "Автомобиль" : "Грузовик";
        return type + " {" +
                "номер '" + numberPlate + '\'' +
                ", скорость " + speed + " км/ч" +
                ", вес " + weightInTons + "т" +
                ", ширина " + width + "м" +
                ", длина " + length + "м" +
                ", высота " + height + "м" +
                '}';
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getSpeed() {
        return speed;
    }

    public double getWeightInTons() {
        return weightInTons;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public boolean isUnderArrest() {
        return underArrest;
    }

    public String getType() {
        if (this.getClass().getSimpleName().equals("Car")) {
            return "Автомобиль";
        } else if (this.getClass().getSimpleName().equals("Truck")) {
            return "Грузовик";
        } else {
            return "Т/С неопознанного типа";
        }
    }

    public void setUnderArrest(boolean underArrest) {
        this.underArrest = underArrest;
    }
}
