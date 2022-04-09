package lesson10;

import lesson10.inter.Checkable;
import lesson10.inter.Printable;

public class Printer extends  AbstractPrinter implements Printable, Checkable {
    public Printer() {
        super("Консоль");
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void print() {
        //System.out.println("Печать из класса " + Printer.class.getName());
        System.out.println("Печать из класса " + this.getClass().getName() + " в " + getSource());
    }

    @Override
    public void print(int index) {
        Printable.super.print(index);
    }
}
