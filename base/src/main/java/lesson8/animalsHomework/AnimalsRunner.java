package lesson8.animalsHomework;

public class AnimalsRunner {

    public static void main(String[] args) {

        Cat vasya = new Cat("Вася", 5);
        Dog bobik = new Dog("Бобик", 2);
        Cow burenka = new Cow("Буренка", 12);
        Animal gosha = new Animal("Гоша", 3);

        Animal[] array = new Animal[] {vasya, bobik, burenka, gosha};

        for (Animal animal : array) {
            animal.beOlder();
            animal.voice();
        }
    }
}
