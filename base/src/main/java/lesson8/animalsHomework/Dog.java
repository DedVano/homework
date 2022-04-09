package lesson8.animalsHomework;

public class Dog extends Animal {

    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("Собака " + name + " лает");
    }
}

