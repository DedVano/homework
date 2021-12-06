package lesson10.converterHomework.interfaces;

import lesson10.converterHomework.unitEnumerations.MassUnits;

public interface Convertable {

    Convertable convert(MassUnits unit);

    double getValue();

    MassUnits getUnit();

    /**
     * Метод производит вывод результата конвертации из одного класса единиц измерения в другой.
     *
     * @param sourceUnit исходный объект преобразования
     * @param targetUnit объект - результат преобразования
     */
    static void print(Convertable sourceUnit, Convertable targetUnit) {
        System.out.println(sourceUnit.getValue() + " " + sourceUnit.getUnit().getRusNameInGenitiveCase() + " равняется "
                + targetUnit.getValue() + " " + targetUnit.getUnit().getRusNameInGenitiveCase());
    }
}
