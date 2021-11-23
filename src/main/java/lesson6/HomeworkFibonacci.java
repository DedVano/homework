package lesson6;

import java.util.Scanner;

public class HomeworkFibonacci {

    public static void main(String[] args) {

        long[] fibonacciArray = new long[93];
        int lastCachedValue = 0;
        System.out.println("Давайте рассчитаем немного Фибоначчи.");
        System.out.println("Введите номер члена последовательности от 0 до 92, и мы его рассчитаем, а если он уже есть " +
                "в кэше, то будет еще проще, сразу покажем.");
        System.out.println("Для выхода введите 'exit'.");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                String text = scanner.nextLine();
                if (text.equals("exit")) {
                    scanner.close();
                    return;
                }
                System.out.println("'" + text + "' как-то не очень похоже на номер.. Попробуйте еще раз, только нужно " +
                        "ввести целое число от 0 до 92, либо команду 'exit'.");
            }
            int itemNumber = scanner.nextInt();
            if (itemNumber < 0 || itemNumber > 92) {
                System.out.println("Нужно ввести число от 0 до 92, либо команду 'exit'.");
            } else if (itemNumber > lastCachedValue) {
                fillFibonacciArray(fibonacciArray, itemNumber, lastCachedValue);
                lastCachedValue = itemNumber;
                System.out.println("Элемент №" + itemNumber + " в последовательности Фибоначчи имеет значение "
                        + fibonacciArray[itemNumber] + ", рассчитано и включено в кэш.");
            } else {
                System.out.println("Элемент №" + itemNumber + " в последовательности Фибоначчи имеет значение "
                        + fibonacciArray[itemNumber] + ", взято из кэша");
            }
        }
    }

    /**
     * Метод производит заполнение массива значениями из ряда Фибоначчи от m-го до n-го члена последовательности, <br>
     * где n может принимать значения от 1 до 92 включительно (в силу специфики реализации данного класса,        <br>
     * нулевой элемент массива изначально равен 0 и не требует заполнения).                                       <br>
     * Расчет ограничен 92-м членом последовательности из-за примененного в массиве типа long.                    <br>
     * Расчет 93-го члена последовательности приведет к выходу за пределы данного типа.                           <br>
     * Расчет ведется с помощью цикла, что, в отличие от расчета методом рекурсии, при расчете высоких номеров    <br>
     * не приводит к существенному замедлению расчета.
     *
     * @param itemNumber      номер члена последовательности, ДО которого требуется заполнение массива, от 1 до 92
     * @param lastCachedValue номер члена последовательности, ОТ которого требуется заполнение массива
     */
    public static void fillFibonacciArray(long[] array, int itemNumber, int lastCachedValue) {
        if (lastCachedValue < 1) {
            array[1] = 1;
        }
        for (int i = Math.max(lastCachedValue + 1, 2); i <= itemNumber; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
    }
}
