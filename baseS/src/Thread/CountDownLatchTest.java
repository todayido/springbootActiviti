package Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        try {
            CountDownLatch sub = new CountDownLatch(3);
            CountDownLatch parent = new CountDownLatch(1);

            // 父类线程等待所有的子类线程执行完之后再知行
            new Thread(() -> {
                try {
                    parent.await();
                    System.out.println("1：我在工作..........");
                    sub.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    parent.await();
                    System.out.println("2：我在工作..........");
                    sub.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


            new Thread(() -> {
                try {
                    parent.await();
                    System.out.println("3：我在工作..........");
                    sub.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            parent.countDown();// 下命令通知三个线程可以开始工作了
            sub.await();// 开始等着子线程开始干活
            System.out.println("所有子线程执行完毕");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
