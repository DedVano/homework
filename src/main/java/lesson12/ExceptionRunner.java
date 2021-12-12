package lesson12;

public class ExceptionRunner {
    public static void main(String[] args) {
        boolean succeeded = false;
        try {
            System.out.println("Пытаемся:");
            divide (5,0);
            succeeded = true;
        }
        catch (ArithmeticException exception) {
            exception.printStackTrace();
            succeeded = false;
        }
        finally {
            System.out.println(succeeded ? "Выполнение операции завершено успешно." : "Не прокатило");
        }
    }

    private static int divide (int i, int i1) {
        return i / i1;
    }
}
