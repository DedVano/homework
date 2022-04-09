package lesson11.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticRunner1 {
    public static void main(String[] args) {
        int num1;

        System.out.println("Введите два числа для деления друг на друга:");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите сначала первое число:");
            num1 = scanner.nextInt();
        } catch (Exception e) {
            num1 = 11;
            scanner.next();
        }
        int num2 = 0;
        try {
            System.out.println("Теперь введите второе:");
            num2 = scanner.nextInt();
            int result = divide(num1, num2);
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Во время операции деления произошла ошибка.");
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод.");
            scanner.next();
            num2 = 11;
            int result = divide(num1, num2);
            System.out.println("Результат деления: " + result);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        } finally {
            System.out.println("a = " + num1 + ", b = " + num2);
        }
        System.out.println("Hello world");

    }

    public static int divide(int a, int b) {
        //return a / b;
        return new Calculator().division(a, b);
    }
}
