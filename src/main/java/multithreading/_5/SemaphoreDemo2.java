package multithreading._5;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }

    private static class Car implements Runnable {

        private final int number;
        private static final int MAX_LOTS = 5;
        private Semaphore semaphore = new Semaphore(MAX_LOTS, true);
        private final static boolean[] PARKING_LOTS = new boolean[MAX_LOTS];

        Car(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Автомобиль с номером " + number + " подъехал к стоянке (" + name + ")");

            try {
                semaphore.acquire();
                synchronized (PARKING_LOTS) {
                    int lotNumber = -1;
                    for (int i = 0; i < MAX_LOTS; i++) {
                        if (!PARKING_LOTS[i]) {
                            PARKING_LOTS[i] = true;
                            lotNumber = i;
                        }
                    }
                }

            } catch (InterruptedException e) {
                semaphore.release();
            }
        }
    }
}
