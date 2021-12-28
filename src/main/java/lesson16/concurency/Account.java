package lesson16.concurency;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }

    public void withdraw(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
