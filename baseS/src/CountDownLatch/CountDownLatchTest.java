package CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class CountDownLatchTest {


    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(1);

        new Thread(() -> {
            try {
                count.await();
                System.out.println("线程1结束执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
//                    TimeUnit.MILLISECONDS.sleep(1000);
                    if (i == 4) {
                        count.countDown();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
