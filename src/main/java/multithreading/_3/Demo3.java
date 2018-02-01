package multithreading._3;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
        System.out.println("start balance = " + account.getBalance());

        WithdrawThread withdrawThread = new WithdrawThread(account);
        DepositThread depositThread = new DepositThread(account);
        depositThread.start();
        withdrawThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("end balance = " + account.getBalance());
    }


    private static class WithdrawThread extends Thread {
        private final Account account;

        public WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }
    }
}