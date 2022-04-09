package lesson5;

import java.util.Scanner;

public class FibonaciHomework {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте рассчитаем немного Фибоначчи.");
        System.out.println("Введите номер члена последовательности от 0 до 46, и мы его рассчитаем:");
        while (!scanner.hasNextInt()) {
            String text = scanner.next();
            System.out.println("'" + text + "' как-то не очень похоже на номер.. Попробуйте еще раз, только нужно " +
                    "целое число");
        }
        int itemNumber = scanner.nextInt();

        // расчет последовательности методом цикла с замером затраченного времени
        long startTime = System.nanoTime();
        int itemValue = fibonacciCalcCycle(itemNumber);
        long estimatedTime = System.nanoTime() - startTime;
        if (itemValue != -1) {
            System.out.println("Элемент №" + itemNumber + " в последовательности Фибоначчи имеет значение " + itemValue +
                    " , на расчет циклом затрачено " + estimatedTime + " наносекунд");
        } else {
            System.out.println("Расчет циклом не удался, похоже, что-то Вы все-таки ввели не то.");
        }

        // расчет последовательности методом рекурсии с замером затраченного времени
        startTime = System.nanoTime();
        itemValue = fibonacciCalcRecursion(itemNumber);
        estimatedTime = System.nanoTime() - startTime;
        double estimatedTimeInSeconds = (double) estimatedTime / 1000000000;
        if (itemValue != -1) {
            System.out.println("Элемент №" + itemNumber + " в последовательности Фибоначчи имеет значение " + itemValue +
                    " , на расчет рекурсией затрачено " + estimatedTime + " наносекунд, т.е. " + estimatedTimeInSeconds +
                    " секунд");
        } else {
            System.out.println("Расчет рекурсией не удался, похоже, что-то Вы все-таки ввели не то.");
        }
    }

    /**
     * Метод рассчитывавет значение n-го члена последовательности Фибоначчи, где n может принимать значния от 0 до 46. <br>
     * Расчет ограничен 46-м членом последовательности из-за примененного возвращаемого методом типа int.   <br>
     * Расчет 47-го члена последовательности приведет к выходу за пределы данного типа.  <br>
     * Расчет ведется с помощью рекурсивного вызова метода, что при расчете высоких номеров может привести  <br>
     * к существенному замедлению расчета.
     *
     * @param itemNumber - номер члена последовательности от 0 до 46
     * @return - значение указанного члена последовательности
     */
    public static int fibonacciCalcRecursion(int itemNumber) {

        if (itemNumber == 0) {
            return 0;
        } else if (itemNumber == 1) {
            return 1;
        } else if ((itemNumber <= 46) && (itemNumber > 1)) {
            return fibonacciCalcRecursion(itemNumber - 1) + fibonacciCalcRecursion(itemNumber - 2);
        }
        return -1;
    }

    /**
     * Метод рассчитывавет значение n-го члена последовательности Фибоначчи, где n может принимать значния от 0 до 46. <br>
     * Расчет ограничен 46-м членом последовательности из-за примененного возвращаемого методом типа int.   <br>
     * Расчет 47-го члена последовательности приведет к выходу за пределы данного типа.  <br>
     * Расчет ведется с помощью цикла, что при расчете высоких номеров не приводит  <br>
     * к замедлению расчета.
     *
     * @param itemNumber - номер члена последовательности от 0 до 46
     * @return - значение указанного члена последовательности
     */
    public static int fibonacciCalcCycle(int itemNumber) {

        if (itemNumber == 0) {
            return 0;
        } else if (itemNumber == 1) {
            return 1;
        } else if ((itemNumber <= 46) && (itemNumber > 1)) {
            int nextItemValue = 0;
            int currentItemValue = 1;
            int prevItemValue = 0;
            for (int i = 2; i <= itemNumber; i++) {
                nextItemValue = currentItemValue + prevItemValue;
                prevItemValue = currentItemValue;
                currentItemValue = nextItemValue;
            }
            return nextItemValue;
        }
        return -1;
    }
}
