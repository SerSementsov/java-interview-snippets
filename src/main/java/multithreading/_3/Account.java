package multithreading._3;

public class Account {

    private long balance;

    Account(long balance) {
        this.balance = balance;
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
//        synchronized (this) {
            balance += amount;
//        }
    }

    public void withdraw(long amount) {
        checkAmountNonNegative(amount);
//        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
//        }
    }

    public long getBalance() {
        return balance;
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
