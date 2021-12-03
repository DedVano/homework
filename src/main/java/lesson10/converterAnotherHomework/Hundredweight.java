package lesson10.converterAnotherHomework;

public class Hundredweight implements Convertable {

    double value;
    MassUnits unit = MassUnits.HUNDREDWEIGHT;

    public Hundredweight(double value) {
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
