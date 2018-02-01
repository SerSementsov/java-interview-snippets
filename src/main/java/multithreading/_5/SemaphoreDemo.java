package multithreading._5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2, true);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread worker = new WorkerThread(semaphore);
            threads.add(worker);
            worker.start();
        }

        Thread.sleep(20_000L);

        for (Thread thread : threads) {
            thread.interrupt();
        }

    }

    private static class WorkerThread extends Thread {
        private final Semaphore semaphore;

        private WorkerThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }

        private void runUnsafe() throws InterruptedException {
            while (true) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquired semaphore");
                    Thread.sleep(5_000L);
                } finally {
                    semaphore.release();
                    System.out.println(getName() + " released semaphore");
                }
            }
        }
    }
}
