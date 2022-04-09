package lesson7.homework;

public class PetsRunner {

    public static void main(String[] args) {

        Dog bobik = new Dog("Бобик", 5, true);
        bobik.beOlder();
        bobik.run(50);
        bobik.run(800);
        bobik.swim(10);
        bobik.swim(600);
        bobik.jump(1);
        bobik.jump(6);

        Cat vasya = new Cat("Васька", 3, true);
        vasya.beOlder();
        vasya.run(50);
        vasya.run(800);
        vasya.swim(10);
        vasya.swim(600);
        vasya.jump(1);
        vasya.jump(6);

    }
}
