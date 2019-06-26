package CountDownLatch;

public class WaitNotifyTest {

    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("线程1执行结束");
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 4) {
                    synchronized (lock) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
