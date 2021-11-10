package lesson4;

import java.util.Scanner;

public class ScannerRunner {
    public static void main(String[] args) {

        Scanner inputItem = new Scanner(System.in);
        System.out.println("Представьтесь! ");
        String userName = inputItem.nextLine();
        System.out.println("Добро пожаловать, "+ userName + ". Введите число для расчета:");

        int value = inputItem.nextInt(); // выяснить про защиту от ввода незапланированного типа
        System.out.println("Подтверждаем, что Вы ввели " + value);
    }
}
