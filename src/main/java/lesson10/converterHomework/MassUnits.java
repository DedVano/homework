package lesson10.converterHomework;

public enum MassUnits {
    MICROGRAM("микрограмм", "микрограмм", 0.000001, 1),
    MILLIGRAM("миллиграмм", "миллиграмм", 0.001, 2),
    GRAM("грамм", "грамм", 1, 3),
    KILOGRAM("килограмм", "килограмм", 1_000, 4),
    HUNDREDWEIGHT("центнер", "центнеров", 100_000, 5),
    TON("тонна", "тонн", 1_000_000, 6),
    POUND("фунт", "фунтов", 453.59237, 7),
    OUNCE("унция", "унций", 28.349523, 8),
    GRAIN("гран", "гранов", 0.064799, 9),
    POOD("пуд", "пудов", 16380.4964, 10),
    CARAT("карат", "каратов", 0.2, 11);

    String rusName;
    String rusNameInGenitiveCase;
    double ratio;
    int index;

    MassUnits(String rusName, String rusNameInGenitiveCase, double ratio, int index) {
        this.rusName = rusName;
        this.rusNameInGenitiveCase = rusNameInGenitiveCase;
        this.ratio = ratio;
        this.index = index;
    }

    public static MassUnits as(int index) {
        for (MassUnits unit : values()) {
            if (unit.index == index) {
                return unit;
            }
        }
        return MassUnits.GRAM;
    }
}
