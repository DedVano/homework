package lesson12;

import lesson12.exception.NotEnoughMonetException;

public class AccountRunner {

    public static void main(String[] args) {
        Account account = new Account(1000);
        System.out.println("Текцщий баланс " + account.getBalance());
        try {
            int amount = 5000;
            account.withdraw(amount);
        } catch (NotEnoughMonetException exception) {
            exception.printStackTrace();
            System.out.println("Снятия не произошло. Состояние баланса " + exception.getBalance());
        }
        System.out.println("Текцщий баланс " + account.getBalance());
    }
}
