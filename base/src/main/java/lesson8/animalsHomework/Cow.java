package lesson8.animalsHomework;

public class Cow extends Animal {


    public Cow() {
        super();
    }

    public Cow(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("Корова " + name + " мычит");
    }
}

