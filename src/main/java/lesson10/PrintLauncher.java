package lesson10;

import lesson10.inter.Printable;

public class PrintLauncher {

    public static void main(String[] args) {
        Printable printable = new Printer();
        printable.print();
    }
}
