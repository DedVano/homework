package lesson10.converterHomework;

public class Hundredweight implements Convertable {

    final double value;
    final MassUnits unit = MassUnits.HUNDREDWEIGHT;

    public Hundredweight(double value) {
        this.value = value;
    }

    @Override
    public Convertable convert(MassUnits unit) {
        return Convertable.createNew(unit, this.value * this.unit.ratio / unit.ratio);
    }

    public double getValue() {
        return value;
    }

    public MassUnits getUnit() {
        return unit;
    }
}
