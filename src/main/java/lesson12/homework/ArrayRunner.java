package lesson12.homework;

import lesson12.homework.exceptions.MyArrayDataException;
import lesson12.homework.exceptions.MyArraySizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayRunner {

    public static void main(String[] args) {

        System.out.println("""
                                
                Нам нужно создать матрицу размера 5х5, заполненную целыми числами. После этого мы просуммируем все её значения.
                Если Вы заполните её не целыми числами, или у Вас получится матрица неправильного размера, то, к сожалению, ничего не получится.
                """);
        List<List<String>> valuesMatrix = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String incomingValue;
        boolean firstString = true;
        do {
            List<String> formedString = new ArrayList<>();
            System.out.println("Введите значения " + (firstString ? "первой" : "следующей") + " строки по очереди или сразу все через пробел.");
            System.out.println("Ввод строки должен окончиться на знак '/'");
            System.out.println("Если Вы закончили ввод всей матрицы, введите знак '*'");
            firstString = false;
            do {
                incomingValue = scanner.next();
                if (!incomingValue.equals("/") && (!incomingValue.equals("*"))) {
                    formedString.add(incomingValue);
                } else break;
            } while (true);
            valuesMatrix.add(formedString);
        } while (!incomingValue.equals("*"));
        scanner.close();

        System.out.println("\nИтак, у Вас получилась вот такая матрица:");
        boolean printSuccess = matrixPrint(valuesMatrix);

        if (printSuccess) {
            System.out.println("Попробуем её просуммировать.");
            try {
                System.out.println("Итоговая сумма равна " + summ(valuesMatrix));
            } catch (MyArraySizeException mase) {
                System.out.print("Не получилось. ");
                if (mase.isProblemInRowsQuantity()) {
                    System.out.println("Число строк Вашей матрицы равно " + mase.getIncomingArrayRows() +
                            ", а надо 5.");
                } else {
                    System.out.println(mase.getRowCausedProblem() + "-я строка имеет длину " + mase.getLengthOfProblemRow() +
                            ", а надо 5.");
                }
            } catch (MyArrayDataException made) {
                System.out.println("Не получилось. В строке " + made.getRowCausedProblem() + ", столбце " +
                        made.getColumnCausedProblem() + " стоит значение " + made.getWrongField() + ", а это не целое число.");
            }
        } else {
            System.out.println("С суммированием элементов матрицы возникли проблемы, нам даже распечатать её не получилось, " +
                    "какое уж тут суммирование...");
        }
    }

    /**
     * Метод осуществляет суммирование всех ячеек матрицы, передаваемой в качестве аргумента.
     * В случае несоответствия размера передаваемой матрицы (5х5) генерирует исключение MyArraySizeException.
     * В случае обнаружение в элементах передаваемой матрицы несоответствующего заданному типу (целое число)
     * генерирует исключение MyArrayDataException.
     *
     * @param matrix матрица, элементы которой подлежат суммированию
     * @return сумма элементов передаваемой матрицы
     */
    public static int summ(List<List<String>> matrix) {
        if (matrix.size() != 5) {
            throw new MyArraySizeException("Количество строк не совпадает с заданным.", true, matrix.size());
        }
        for (List<String> row : matrix) {
            if (row.size() != 5) {
                throw new MyArraySizeException("Количество значений в строке не совпадает с заданным.", matrix.indexOf(row),
                        row.size());
            }
        }
        int sumValue = 0;
        for (List<String> row : matrix) {
            for (String value : row) {
                try {
                    sumValue += Integer.parseInt(value);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException("Обнаружены данные, не являющиеся целым числом.", matrix.indexOf(row),
                            row.indexOf(value), value);
                }
            }
        }
        return sumValue;
    }

    /**
     * Медод осуществляет вывод на экран консоли значений матрицы, передаваемой в качестве аргумента, в удобном для
     * чтения и восприятия формате.
     *
     * @param matrix матрица, подлежащая выводу на экран
     * @return признак успешной печати, true или false
     */
    public static boolean matrixPrint(List<List<String>> matrix) {

        boolean matrixIsEmpty = true;
        int maxLength = 0;
        for (List<String> row : matrix) {
            if (row.size() != 0) {
                matrixIsEmpty = false;
            }
            for (String item : row) {
                maxLength = Math.max(item.length() + 2, maxLength);
            }
        }
        if (matrixIsEmpty) {
            System.out.println("Матрица пуста");
            return false;
        }

        for (List<String> row : matrix) {
            for (String item : row) {
                System.out.printf("%" + maxLength + "s", item);
            }
            System.out.println();
        }
        return true;
    }
}
