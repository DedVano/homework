package lesson12.cornercase;

import lesson12.exception.UnnamedException;

import java.util.Random;

public class InitialisingBlock {

    private String name;

    static {
        //name = "Example";
        if (new Random().nextBoolean()) {
            throw new UnnamedException("Неизвестный блок");
        }

    }

    public InitialisingBlock() {
        //throw new UnnamedException("Задайте имя объекта");
        this.name = "Unknown";
    }

    public InitialisingBlock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
