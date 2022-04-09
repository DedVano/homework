package lesson16.concurency;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(BigDecimal money) {
//        synchronized (this) {
            this.balance = balance.add(money);
//        }
    }

    public synchronized void withdraw(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static void print(Account account, String str) {
//        synchronized (Account.class) {
            System.out.println(str + account);
//        }
    }
}
