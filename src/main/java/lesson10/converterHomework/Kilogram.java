package lesson10.converterHomework;

public class Kilogram implements Convertable {

    final double value;
    final MassUnits unit = MassUnits.KILOGRAM;

    public Kilogram(double value) {
        this.value = value;
    }

    @Override
    public Convertable convert(MassUnits unit) {
        return Convertable.create_new(unit, this.value * this.unit.ratio / unit.ratio);
    }

    public double getValue() {
        return value;
    }

    public MassUnits getUnit() {
        return unit;
    }
}
