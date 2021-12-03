package lesson10.converterHomework;

import java.util.Scanner;

public class ConvertRunner {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Выберите единицы измерения, которые будем конвертировать.");
        MassUnits sourceUnits = getUnits();
        System.out.println("Теперь введите значение в выбранных единицах.");
        double sourceValue = getValue();
        System.out.println("Теперь выберите единицы измерения для конвертации.");
        MassUnits targetUnits = getUnits();

        Convertable sourceUnit = Convertable.create_new(sourceUnits, sourceValue);
        Convertable targetUnit = sourceUnit.convert(targetUnits);

        System.out.println();
        Convertable.print(sourceUnit, targetUnit);
    }


    private static MassUnits getUnits() {

        for (MassUnits unit : MassUnits.values()) {
            System.out.println(unit.ordinal() + ". " + unit.rusName);
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите номер единиц измерения: ");
            while (!scanner.hasNextInt()) {
                String text = scanner.next();

            }
            int itemNumber = scanner.nextInt();
            for (MassUnits unit : MassUnits.values()) {
                if (unit.ordinal() == itemNumber) {
                    return unit;
                }
            }
        } while (true);
    }

    private static double getValue() {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите положительное число: ");
            while (!scanner.hasNextDouble()) {
                String text = scanner.next();
            }
            double itemValue = scanner.nextDouble();
            if (itemValue >= 0) {
                return itemValue;
            }
        } while (true);
    }

}
