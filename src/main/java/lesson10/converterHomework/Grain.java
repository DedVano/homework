package lesson10.converterHomework;

public class Grain implements Convertable {

    final double value;
    final MassUnits unit = MassUnits.GRAIN;

    public Grain(double value) {
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
