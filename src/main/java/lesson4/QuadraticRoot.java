package lesson4;

import java.util.Scanner;

public class QuadraticRoot {

    public static void main(String[] args) {

        Scanner incomingParameter = new Scanner(System.in);
        int quadRoot;

        System.out.println("Введите число, для которого Вы хотите найти квадратный корень:");
        int n = incomingParameter.nextInt();
        if (n < 0) {
            System.out.println("Нужно ввести целое положительное число");
        } else {
            quadRoot = quadRootCalc(n);
            if (quadRoot != -1) {
                System.out.printf("Квадратный корень из %d равен %d\n", n, quadRoot);
            } else System.out.printf("Для числа %d не получилось найти квадратный корень\n", n);
        }

    }

    public static int quadRootCalc(int n) {

        for (int i = 0; i <= 46340; i++) {
            if (i * i == n) {
                return i;
            }
        }
        return -1;
    }
}