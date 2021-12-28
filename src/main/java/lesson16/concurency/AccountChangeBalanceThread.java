package lesson16.concurency;

import java.math.BigDecimal;

public class AccountChangeBalanceThread extends Thread {

    private final Account account;

    public AccountChangeBalanceThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            account.deposit((new BigDecimal(2000)));
            Thread.sleep(1000);
            account.deposit(new BigDecimal(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
