package lesson10.converterHomework;

public enum MassUnits {
    MICROGRAM ("микрограмм", 0.000001, 1),
    MILLIGRAM ("миллиграмм", 0.001, 2),
    GRAM ("грамм", 1, 3),
    KILOGRAM ("килограмм", 1_000, 4),
    HUNDREDWEIGHT("центнер", 100_000, 5),
    TON ("тонна", 1_000_000, 6),
    POUND ("фунт", 453.59237, 7),
    OUNCE ("унция", 28.349523, 8),
    GRAIN ("гран", 0.064799, 9),
    POOD ("пуд", 16380.4964, 10),
    CARAT ("карат", 0.2, 11);

    String rusName;
    double ratio;
    int index;

    MassUnits (String rusName, double ratio, int index) {
        this.rusName = rusName;
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
