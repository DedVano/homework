package lesson9;

public class CompanyAccount extends Account {

    public static int COUNT = 0;

    //private static final double COURSE = 75.56; // 1$ = 75.56 рублей

    public CompanyAccount(String name) {
        super(name);
        COUNT++;
    }

    public  double getBalanceInDollars() {
        return this.getBalance() / Course.CURRENT_VALUE;
    }
}
