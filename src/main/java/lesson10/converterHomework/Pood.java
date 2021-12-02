package lesson10.converterHomework;

public class Pood implements Convertable {

    double value;
    MassUnits unit = MassUnits.POOD;

    public Pood(double value) {
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
