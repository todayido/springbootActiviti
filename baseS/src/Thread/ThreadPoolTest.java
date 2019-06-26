package Thread;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        System.out.println(pool);

        for (int i = 0; i < 6; i++) {
            pool.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(pool);
        pool.shutdown();
        System.out.println(pool.isShutdown());
        System.out.println(pool.isTerminated());
        System.out.println(pool);

    }
}
