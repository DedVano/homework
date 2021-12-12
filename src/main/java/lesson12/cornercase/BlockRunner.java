package lesson12.cornercase;

import lesson12.exception.UnnamedException;

public class BlockRunner {
    public static void main (String[] args) throws UnnamedException {
        System.out.println("Пытаемся инициализировать блок");
        InitialisingBlock initialisingBlock = new InitialisingBlock();
        System.out.println(initialisingBlock.getName());
    }
}
