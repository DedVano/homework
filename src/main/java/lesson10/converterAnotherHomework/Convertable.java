package lesson10.converterAnotherHomework;

public interface Convertable {

    Convertable convert(MassUnits unit); /*{
        return this.create_new(unit, this.value / unit.ratio);
    }*/


    default Convertable create_new(MassUnits unit, double value) {
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

    static void print(double firstValue, MassUnits firstUnit, double secondValue,MassUnits secondUnit) {
        System.out.println(firstValue + " " + firstUnit.rusName + " равняется " + secondValue + " " + secondUnit.rusName);
    }
}
