package multithreading._2;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        SleeperThread sleeper = new SleeperThread();

//        worker.setDaemon(true);
        sleeper.setDaemon(true);

        System.out.println("Starting threads");
        worker.start();
        sleeper.start();

        /*
        Thread.sleep(100L);

        System.out.println("Interrupting threads");
        worker.interrupt();
        sleeper.interrupt();

        System.out.println("Joining threads");
        worker.join();
        sleeper.join();
*/

        System.out.println("All done");
    }

    private static class WorkerThread extends Thread {

        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sum += i;
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("Worker interrupted at i = " + i);
                    break;
                }
            }
            System.out.println("sum = " + sum);
        }
    }


    private static class SleeperThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println("Sleeper interrupted");
            }
        }
    }

}
