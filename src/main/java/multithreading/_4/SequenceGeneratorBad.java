package multithreading._4;

import java.util.ArrayList;
import java.util.List;

public class SequenceGeneratorBad {

    private volatile static int counter = 0;

    private static void nextInt() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> { for (int j = 0; j < 1000; j++) nextInt(); });
            thread.start();
            threads.add(thread);
        }


        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);
    }

}
