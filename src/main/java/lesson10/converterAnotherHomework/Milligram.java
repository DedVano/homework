package lesson10.converterAnotherHomework;

public class Milligram implements Convertable {

    double value;
    MassUnits unit = MassUnits.MILLIGRAM;

    public Milligram(double value) {
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
