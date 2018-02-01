package multithreading._3;

public class Demo4 {

    public static void main(String[] args) {
        Account acc1 = new Account(10);
        Account acc2 = new Account(20);
        System.out.println("BEFORE:");
        System.out.println("acc1 balance = " + acc1.getBalance());
        System.out.println("acc2 balance = " + acc2.getBalance());

        new Thread(() -> {
            transfer(acc1, acc2, 1);
        }).start();

        transfer(acc2, acc1, 1);
        System.out.println("AFTER:");
        System.out.println("acc1 balance = " + acc1.getBalance());
        System.out.println("acc2 balance = " + acc2.getBalance());

    }

    private synchronized static void transfer(Account acc1, Account acc2, long amount) {
        if (acc1.getBalance() < amount) {
            throw new IllegalArgumentException("not enough money");
        }

        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
