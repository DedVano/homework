package lesson8.animalsHomework;

public class Cat extends Animal {

    public Cat(String s) {
        super();
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("Кошка " + name + " мяукает");
    }
}
