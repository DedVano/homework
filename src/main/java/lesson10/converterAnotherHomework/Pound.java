package lesson10.converterAnotherHomework;

public class Pound implements Convertable {

    double value;
    MassUnits unit = MassUnits.POUND;

    public Pound(double value) {
        this.value = value;
    }

    @Override
    public Convertable convert(MassUnits unit) {
        return this.create_new(unit, this.value * this.unit.ratio / unit.ratio);
    }

    public double getValue() {
        return value;
    }

    public MassUnits getUnit() {
        return unit;
    }
}
