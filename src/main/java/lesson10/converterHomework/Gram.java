package lesson10.converterHomework;

public class Gram implements Convertable {
    double value;
    MassUnits unit = MassUnits.GRAM;
//    double valueConvertedToGram;

    public Gram(double value) {
        this.value = value;
//        this.valueConvertedToGram = value * MassUnits.GRAM.ratio;
    }

    @Override
    public Convertable convert(MassUnits unit) {
//        return this.valueConvertedToGram / unit.ratio;
        return this.create_new(unit, this.value * this.unit.ratio / unit.ratio);
    }

    public double getValue() {
        return value;
    }

    public MassUnits getUnit() {
        return unit;
    }
}
