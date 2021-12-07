package lesson11.homework.enumerations;

public enum NumberplateRegions {
    R78(78), R98(98), R178(178), R198(198), R77(77),
    R99(99), R177(177), R199(199), R777(777), R799(799);

    int regionValue;

    NumberplateRegions(int regionValue) {
        this.regionValue = regionValue;
    }

    public int getRegionValue() {
        return regionValue;
    }
}
