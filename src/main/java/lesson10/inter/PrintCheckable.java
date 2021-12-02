package lesson10.inter;

public interface PrintCheckable extends Printable, Checkable{

    void otherPrint();

    default void print(int index) {
        Checkable.super.print(index);
    }
}
