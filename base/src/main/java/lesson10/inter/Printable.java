package lesson10.inter;

import lesson10.enumeration.Language;

public interface Printable {
    int INDEX = 1; // bad practice

    void print();

    static void print(String str) {
        System.out.println(str);
    }

    default void print(int index) {
        System.out.println(index);
    }

    default void printHelloWorld(Language language) {
        switch (language) {
            case RUSSIAN -> System.out.println("Привет мир");
            case ENGLISH -> System.out.println("Hello world");
            case GERMAN -> System.out.println("Hallo Welt");
            case FRENCH -> System.out.println("Salut le monde");
        }
    }
}
