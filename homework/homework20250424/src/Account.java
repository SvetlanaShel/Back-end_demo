import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final ReentrantLock lock = new ReentrantLock();
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public ReentrantLock getLock() {
        return lock;
    }
    public int getBalance() {
        return balance;
    }
}
