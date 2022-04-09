package lesson10;

import lesson10.enumeration.Language;
import lesson10.inter.Printable;

public class EnumRunner {
    public static void main(String[] args) {

        Printable printable = new Printer();
        printable.printHelloWorld(Language.ENGLISH);
        printable.printHelloWorld(Language.RUSSIAN);
        printable.printHelloWorld(Language.FRENCH);

        printable.printHelloWorld(Language.as(3));
        printable.printHelloWorld(Language.as(12));

        System.out.println(Language.GERMAN.asString());
        System.out.println(Language.GERMAN);

    }
}
