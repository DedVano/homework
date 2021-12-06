package lesson10.converterHomework;

import lesson10.converterHomework.interfaces.Convertable;
import lesson10.converterHomework.unitEnumerations.MassUnits;
import lesson10.converterHomework.unitClasses.Units;

import java.util.Scanner;

public class ConvertRunner {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Выберите единицы измерения, которые будем конвертировать.");
        MassUnits sourceUnits = getUnits();
        System.out.println("Теперь введите значение в выбранных единицах.");
        double sourceValue = getValue();
        Convertable sourceUnit = Units.createNew(sourceUnits, sourceValue);

        System.out.println("Теперь выберите единицы измерения для конвертации.");
        MassUnits targetUnits = getUnits();
        Convertable targetUnit = sourceUnit.convert(targetUnits);

        System.out.println();
        Convertable.print(sourceUnit, targetUnit);
    }


    /**
     * Метод выводит в консоль список элементов из перечисления MassUnits и запрашивает выбор нужного элемента из списка
     *
     * @return значение выбранного элемента
     */
    private static MassUnits getUnits() {

        for (MassUnits unit : MassUnits.values()) {
            System.out.println(unit.ordinal() + 1 + ". " + unit.getRusName());
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите номер единиц измерения: ");
            while (!scanner.hasNextInt()) {
                scanner.next();

            }
            int itemNumber = scanner.nextInt();
            for (MassUnits unit : MassUnits.values()) {
                if (unit.ordinal() + 1 == itemNumber) {
                    return unit;
                }
            }
        } while (true);
    }

    /**
     * Метод запрашивает у пользователя положительное число типа double
     *
     * @return введенное в консоль число
     */
    private static double getValue() {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите положительное число: ");
            while (!scanner.hasNextDouble()) {
                scanner.next();
            }
            double itemValue = scanner.nextDouble();
            if (itemValue >= 0) {
                return itemValue;
            }
        } while (true);
    }
}
