package lesson10;

import lesson10.inter.PrintCheckable;

public class FilePrinter extends AbstractPrinter implements PrintCheckable {
    @Override
    public void otherPrint() {

    }

    public FilePrinter() {
        super("файл");
    }

    @Override
    public void print() {
//        System.out.println("Печать из класса " + Printer.class.getName());
        System.out.println("Печать из класса " + this.getClass().getName() + " в " + getSource());
        //TODO: размещение текста в файл
    }

    @Override
    public boolean check() {
        return false;
    }
}
