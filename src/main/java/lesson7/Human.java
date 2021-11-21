package lesson7;

public class Human {
    String name;
    String surname;
    int age;
    double weight;
    double height;
    Boolean hasQrCode;

    public Human () {
    }
    public Human(String n, String surname, int age, double weight, double height, Boolean hasQrCode) {
        name = n;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.hasQrCode = hasQrCode;
    }
    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void beOlder() {
        age++;
    }

    public void vaccinated() {
        this.hasQrCode = true;
    }




}
