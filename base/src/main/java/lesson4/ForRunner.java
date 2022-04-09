package lesson4;

public class ForRunner {

    public static void main(String[] args) {

        for (int counter = 1, value = 10; counter <= 100; counter++, value -= 3) {
            if (counter % 2 != 0) {
                continue;
            }
            System.out.println("Текущее значение счетчика: " + counter);
        }
        System.out.println("-----------------");

       /* for (; ; ) {
            System.out.println("что-то");
        } */
    }
}
