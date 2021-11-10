package lesson3;

import java.util.Scanner;

public class Factorials {

    public static void main(String[] args) {

        // Вычисление n!
        Scanner incomingParameter = new Scanner(System.in);
        long nFactorial;

        System.out.println("Давайте вычислим значение факториала для заданного числа n.");
        System.out.print("Введите 'n': ");
        int n = incomingParameter.nextInt();
        if (n < 0) {
            System.out.println("Есть проблема, факториал вычисляется только для чисел не меньше нуля.");
        } else if (n > 39) {
            System.out.println("Извините, но тип данных, примененный в этом решении, не может вместить в себя " +
                    "результат вычисления факториала для n > 39. Пожалуйста, введите число поменьше.");
        } else {
            if (n == 0) {
                nFactorial = 1;
            } else {
                nFactorial = getFactorial(n);
            }
            System.out.printf("%d! = %s\n", n, nFactorial);
        }
    }

    /**
     * Метод вычисляет значение факториала для числа n.
     *
     * @param n корень факториала
     * @return значение факториала
     */
    public static long getFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * getFactorial(--n);
        }

    }
}
