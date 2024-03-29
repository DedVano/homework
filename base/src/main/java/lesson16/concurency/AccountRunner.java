package lesson16.concurency;

import java.math.BigDecimal;

public class AccountRunner {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        AccountIncrementThread accountIncrementThread = new AccountIncrementThread(account, new BigDecimal("10000"));
        accountIncrementThread.start();
//        accountIncrementThread.join();
        AccountDecrementThread accountDecrementThread = new AccountDecrementThread(account, new BigDecimal("5000"));
        accountDecrementThread.start();
//        accountDecrementThread.join();
        AccountChangeBalanceThread accountChangeBalanceThread = new AccountChangeBalanceThread(account);
        accountChangeBalanceThread.start();
//        Thread.sleep(5000);
//        System.out.println("Текущее состояние счета: " + account.getBalance());
    }
}
