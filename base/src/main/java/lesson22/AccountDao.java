package lesson22;

import lesson22.dto.Account;

import java.math.BigDecimal;
import java.util.List;

public class AccountDao {

    public List<Account> getAccounts() {
        //todo физическое извлечение данных из БД
        return List.of(Account.builder().name("account1").balance(BigDecimal.ZERO).build(),
                Account.builder().name("account2").balance(BigDecimal.valueOf(1000)).build(),
                Account.builder().name("account3").balance(new BigDecimal("5000")).build());
    }
}
