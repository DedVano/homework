package lesson4;

public class WhileRunner {
    public static void main(String[] args) {

        int counter = 1;
        while (counter <= 50) {
            System.out.println(counter++);
            // break;
        }

        System.out.println("-----------------------");

        do {
            System.out.println(counter++);
        } while (counter <= 50);
    }
}
