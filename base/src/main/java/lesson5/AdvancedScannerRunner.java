package lesson5;

import java.util.Scanner;

public class AdvancedScannerRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число:");
        while (!scanner.hasNextInt()) {
            String text = scanner.next();
            System.out.println("Просили же целое ввести, а вы не то вводите, ввели " + text);
        }
        int index = scanner.nextInt();
        System.out.println("Наконец-то введено целое число");
    }
}
