package lesson9;

public class Account {

    private double balance = 0.0;
    private String owner = "Unknown";
    private boolean blocked;

    public Account (String name) {
        this.owner = name;
        this.balance = 0.0;
        this.blocked = true;
    }

    public boolean deposit(double amount) {
        if (isBlocked()) return false;
        this.balance += amount;
        return true;
    }

    private boolean isBlocked() {
        if (blocked) {
            return true;
        }
        return false;
    }

    public boolean withdraw (double amount) {
        if (blocked) {
            return false;
        }
        if (this.balance > amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void activated() {
        this.blocked = false;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }


}
