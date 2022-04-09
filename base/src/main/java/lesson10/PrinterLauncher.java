package lesson10;

import lesson10.inter.Printable;

public class PrinterLauncher {

    public static void main(String[] args) {
        Printable printable = new Printer();
        printable.print();
        Printable anotherPrintable = new FilePrinter();
        anotherPrintable.print();
        System.out.println(Printable.INDEX);

        Printable.print("Hello world");
        printable.print(123);
        anotherPrintable.print(123);

    }
}
