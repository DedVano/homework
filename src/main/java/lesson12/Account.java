package lesson12;

import lesson12.exception.NotEnoughMonetException;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit (double amount) {
        balance += amount;
    }
    public double withdraw(double amount) {
        if (balance < amount) {
            throw new NotEnoughMonetException(this.balance, "Произошла ошибка снятия денежных средств. Текущий баланс меньше суммы снятия.");
        }
        balance -= amount;
        return this.balance;
    }

    public double getBalance() {
        return balance;
    }
}
