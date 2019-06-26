package Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                blockingQueue.add("q_" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println("11111111");
                        System.out.println(blockingQueue.take());
                        System.out.println("22222222");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
