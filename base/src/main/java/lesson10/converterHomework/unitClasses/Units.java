package lesson10.converterHomework.unitClasses;

import lesson10.converterHomework.interfaces.Convertable;
import lesson10.converterHomework.unitEnumerations.MassUnits;

public class Units implements Convertable {

    final double value;
    final MassUnits unit;

    protected Units(double value, MassUnits unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public Convertable convert(MassUnits unit) {
        return createNew(unit,
                (double) (Math.round((this.value * this.unit.getRatio() / unit.getRatio()) * 1_000_000_000)) / 1_000_000_000);
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public MassUnits getUnit() {
        return this.unit;
    }

    /**
     * Метод создает объект нового класса единиц мзмерения при конвертации.
     *
     * @param unit  вид единиц измерения, для которых требуется создать объект соответствующего класса (элемент     <br>
     *              перечисления из списка MassUnits)
     * @param value значение объекта соответствующего класса
     * @return объект класса, соответствующего выбранным единицам измерения
     */
    public static Convertable createNew(MassUnits unit, double value) {
        switch (unit) {
            case TON -> {
                return new Ton(value);
            }
            case GRAM -> {
                return new Gram(value);
            }
            case POOD -> {
                return new Pood(value);
            }
            case CARAT -> {
                return new Carat(value);
            }
            case GRAIN -> {
                return new Grain(value);
            }
            case OUNCE -> {
                return new Ounce(value);
            }
            case POUND -> {
                return new Pound(value);
            }
            case KILOGRAM -> {
                return new Kilogram(value);
            }
            case MICROGRAM -> {
                return new Microgram(value);
            }
            case MILLIGRAM -> {
                return new Milligram(value);
            }
            case HUNDREDWEIGHT -> {
                return new Hundredweight(value);
            }
            default -> {
                System.out.println("Неверно указана единица измерения, используем граммы");
                return new Gram(0);
            }
        }
    }
}
