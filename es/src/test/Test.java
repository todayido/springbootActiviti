package test;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) {
        try {
            CountDownLatch count = new CountDownLatch(1);

            new Thread(()->{
                try {
                    while (true) {
                        System.out.println(System.currentTimeMillis() + ": I am running.");
                        Thread.sleep(1000 * 10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
            }).start();
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
