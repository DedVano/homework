package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkMaxMinAndAvgInArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте создадим массив определенной длины и заполним его случайными числами.");
        System.out.println("Укажите, какой длины массив Вы хотите создать (целое положительное число, желательно без " +
                "фанатизма, давайте, например, от 2 до 500):");
        while (!scanner.hasNextInt()) {
            String text = scanner.next();
            System.out.println("Вас просили ввести длину массива, а Вы ввели '" + text + "'. Пожалуйста, введите целое " +
                    "положительное число");
        }
        int arrayLength = scanner.nextInt();

        if (arrayLength > 500) {
            System.out.println("Извините, но Вы хотите создать какой-то очень огромный массив, а ведь мы договаривались");
            return;
        } else if (arrayLength < 0) {
            System.out.println("Сложно себе представить массив с отрицательной длиной, Вас же просили - целое " +
                    "ПОЛОЖИТЕЛЬНОЕ число");
            return;
        } else if (arrayLength == 1 || arrayLength == 0) {
            System.out.println("Тут такое дело, мы хотели после заполнения массива выяснить минимальное и максимальное " +
                    "значения его элементов, а также среднее арифметическое их всех, но с указанной длиной массива это сложно");
            return;
        }

        double[] array = new double[arrayLength];
        fillArray(array);
        double highElement = findHighElement(array);
        double lowElement = findLowElement(array);
        double midValue = findMidValue(array);

        System.out.println("Отлично! Массив длиной " + arrayLength + " создан, вот все его значения: " +
                Arrays.toString(array));
        System.out.println("Максимальное значение всех элементов массива равно " + highElement +
                ", минимальное " + lowElement + ", а среднее арифметическое всех значений равно " + midValue);

    }


    /**
     * Метод производит заполнение массива псевдослучайными значениями в диапазоне [0,1), для удобства округленными     <br>
     * до 4-х знаков после запятой.
     *
     * @param array массив, который требуется заполнить
     */
    public static void fillArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) Math.round(Math.random() * 10000) / 10000;
        }
    }

    /**
     * Метод возвращает максимальное значение всех элементов заданного массива.
     *
     * @param array массив, в котором производится поиск максимального значения
     * @return максимальное значение элементов массива
     */
    public static double findHighElement(double[] array) {
        double highValue = array[0];
        for (double element : array) {
            if (highValue < element) {
                highValue = element;
            }
        }
        return highValue;
    }

    /**
     * Метод возвращает минимальное значение всех элементов заданного массива.
     *
     * @param array массив, в котором производится поиск минимального значения
     * @return минимальное значение элементов массива
     */
    public static double findLowElement(double[] array) {
        double lowValue = array[0];
        for (double element : array) {
            if (lowValue > element) {
                lowValue = element;
            }
        }
        return lowValue;
    }

    /**
     * Метод возвращает среднее арифметическое всех значений элементов заданного массива.
     *
     * @param array массив, для которого рассчитывается среднее арифметическое всех значений
     * @return среднее арифметическое всех значений элементов массива
     */
    public static double findMidValue(double[] array) {
        double summValue = 0;
        for (double element : array) {
            summValue += element;
        }
        return summValue / array.length;
    }

}
