package lesson10.converterHomework;

public class ConvertRunner {

    public static void main(String[] args) {

        double value = 50;
        Convertable unit1 = new Kilogram(50000);
        Convertable unit2 = unit1.convert(MassUnits.TON);
        //Convertable.print(unit1.getValue(), );
        System.out.println();
    }
}
