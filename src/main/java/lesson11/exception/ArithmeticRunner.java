package lesson11.exception;

import java.util.Scanner;

public class ArithmeticRunner {
    public static void main(String[] args) {
        int num1;
        int num2;

        System.out.println("Введите два числа для деления друг на друга:");
        Scanner scanner = new Scanner(System.in);
        /*while (!scanner.hasNextInt()) {
            scanner.next();
        }
        num1 = scanner.nextInt();*/
        try {
            System.out.println("Введите сначала первое число:");
            num1 = scanner.nextInt();
        } catch (Exception e) {
            num1 = 11;
            scanner.next();
        }
        try {
            System.out.println("Теперь введите второе:");
            num2 = scanner.nextInt();
        } catch (Exception e) {
            num2 = 11;
            scanner.next();
        }
        try {
            int result = divide(num1, num2);
            System.out.println("Результат деления: " + result);
        } catch (Exception e) {
            System.out.println("Во время операции деления произошла ошибка.");
        }
        System.out.println("Hello world");

    }

    public static int divide(int a, int b) {
        //return a / b;
        return new Calculator().division(a, b);
    }
}
