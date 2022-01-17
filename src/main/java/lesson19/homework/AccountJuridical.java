package lesson19.homework;

import lombok.ToString;

import java.math.BigDecimal;

@ToString

public class AccountJuridical extends Account {

    private String type;

    public AccountJuridical(String name, String type, BigDecimal balance) {
        super(name, balance);
        this.type = type;
    }
}
