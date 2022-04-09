package lesson19.homework;

import lombok.ToString;

import java.math.BigDecimal;

@ToString

public class AccountNatural extends Account {

    private int age;
    private boolean isMale;

    public AccountNatural(String name, int age, boolean isMale, BigDecimal balance) {
        super(name, balance);
        this.age = age;
        this.isMale = isMale;
    }
}
