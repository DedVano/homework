package lesson19.homework;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString

public class Account {

    private String name;
    private BigDecimal balance;

    public void withdraw(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }

    public void deposit(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    public void print() {
        System.out.println("Баланс " + this.balance);
    }
}

