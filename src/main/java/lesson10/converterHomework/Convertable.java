package lesson10.converterHomework;

public interface Convertable {

    Convertable convert(MassUnits unit);

    double getValue();

    MassUnits getUnit();

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

    /*static void print(double firstValue, MassUnits firstUnit, double secondValue, MassUnits secondUnit) {
        System.out.println(firstValue + " " + firstUnit.rusNameInGenitiveCase + " равняется " + secondValue + " "
                + secondUnit.rusNameInGenitiveCase);
    }*/
    static void print(Convertable sourceUnit, Convertable targetUnit) {
        System.out.println(sourceUnit.getValue() + " " + sourceUnit.getUnit().rusNameInGenitiveCase + " равняется "
                + targetUnit.getValue() + " " + targetUnit.getUnit().rusNameInGenitiveCase);
    }
}
