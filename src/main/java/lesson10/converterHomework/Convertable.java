package lesson10.converterHomework;

public interface Convertable {

    Convertable convert(MassUnits unit);

    double getValue();

    MassUnits getUnit();

    /**
     * Метод создает объект нового класса единиц мзмерения при конвертации. Поскольку метод реализуется во всех     <br>
     * связанных классах одинаково, в целях упрощения рефакторинга и сокращения объема кода он реализован           <br>
     * непосредственно в интерфейсе как метод по умолчанию.
     *
     * @param unit  вид единиц измерения, для которых требуется создать объект соответствующего класса (элемент      <br>
     *              перечисления из списка MassUnits
     * @param value значение объекта соответствующего класса
     * @return объект класса, соответствующего выбранным единицам измерения
     */
    static Convertable create_new(MassUnits unit, double value) {
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

    /**
     * Метод производит вывод результата конвертации из одного класса единиц измерения в другой.
     * Реализован непосредственно в интерфейсе как метод по умолчанию.
     *
     * @param sourceUnit исходный объект преобразования
     * @param targetUnit объект - результат преобразования
     */
    static void print(Convertable sourceUnit, Convertable targetUnit) {
        System.out.println(sourceUnit.getValue() + " " + sourceUnit.getUnit().rusNameInGenitiveCase + " равняется "
                + targetUnit.getValue() + " " + targetUnit.getUnit().rusNameInGenitiveCase);
    }
}
