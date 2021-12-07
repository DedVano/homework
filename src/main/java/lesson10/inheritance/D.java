package lesson10.inheritance;

public class D extends B {

    public D() {
        super(str());
        System.out.println("Вызван конструктор класса D");
    }

    public static String str() {
        return "String";
    }
}
