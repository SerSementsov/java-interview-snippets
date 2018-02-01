package multithreading._6;

import java.util.List;

import static java.util.Arrays.asList;

public class DeadlockDemo {

    private final String str1 = "AAA";
    private final String str2 = "BBB";


    private Thread t1 = new Thread(() -> {
        while (true) {
            synchronized (str1) {
                synchronized (str2) {
                    System.out.println(str1 + str2);
                }
            }
        }
    });

    private Thread t2 = new Thread(() -> {
        while (true) {
            synchronized (str2) {
                synchronized (str1) {
                    System.out.println(str2 + str1);
                }
            }
        }
    });

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();

        demo.t1.setName("thread_1");
        demo.t2.setName("thread_2");


        demo.t1.start();
        demo.t2.start();
    }

}
