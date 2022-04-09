package lesson8.animalsHomework;

public class Animal {

    protected final int legs = 4;
    protected final String name;
    protected int age;

    public Animal() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void voice() {
        System.out.println("Животное " + name + " издает какой-то звук.");
    }

    public void beOlder() {
        age++;
        System.out.println("Животное " + name + " постарело на год, теперь ему " + age + " лет");
    }
}
