package lesson7;

public class PetsRunner {

    public static void main(String[] args) {

        Dog bobik = new Dog("Бобик", 5, true);
        bobik.run(50);
        bobik.run(800);
        bobik.swim(10);
        bobik.swim(600);
        bobik.jump(1);
        bobik.jump(6);

    }
}
