package lesson10.converterHomework.unitEnumerations;

/**
 * Перечисление состоит из списка наименований единиц измерения. Каждый элемент перечисления включает в себя        <br>
 * имя элемента, название элемента на русском языке, это же название в родительном падеже (для использования        <br>
 * в методах вывода на экран), а также коэффициент преобразования данной единицы измерения к базовой                <br>
 * (в данном случае - граммы)
 */
public enum MassUnits {
    MICROGRAM("микрограмм", "микрограмм", 0.000001),
    MILLIGRAM("миллиграмм", "миллиграмм", 0.001),
    GRAM("грамм", "грамм", 1),
    KILOGRAM("килограмм", "килограмм", 1_000),
    HUNDREDWEIGHT("центнер", "центнеров", 100_000),
    TON("тонна", "тонн", 1_000_000),
    POUND("фунт", "фунтов", 453.59237),
    OUNCE("унция", "унций", 28.349523),
    GRAIN("гран", "гранов", 0.064799),
    POOD("пуд", "пудов", 16380.4964),
    CARAT("карат", "каратов", 0.2);

    private final String rusName;
    private final String rusNameInGenitiveCase;
    private final double ratio;

    MassUnits(String rusName, String rusNameInGenitiveCase, double ratio) {
        this.rusName = rusName;
        this.rusNameInGenitiveCase = rusNameInGenitiveCase;
        this.ratio = ratio;
    }

    public String getRusName() {
        return rusName;
    }

    public String getRusNameInGenitiveCase() {
        return rusNameInGenitiveCase;
    }

    public double getRatio() {
        return this.ratio;
    }
}
