package lesson12.exception;

public class NotEnoughMonetException extends RuntimeException {

    private double balance;

    public NotEnoughMonetException(double balance) {
        this.balance = balance;
    }

    public NotEnoughMonetException(double balance, String message) {
        super(message);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
