package CountDownLatch;

import java.util.LinkedList;

public class ProducerAndConsumerTest<T> {
    LinkedList<T> list = new LinkedList<>();
    public static final int MAX = 10;
    int count = 0;

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        System.out.println("wait释放了锁：" + count);
        this.notifyAll();
    }

    public synchronized T get() {
        while (list.size() == 0) {
            try {
                this.wait();
                System.out.println("消费者有数据了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        T t = list.getFirst();
        list.removeFirst();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        ProducerAndConsumerTest p = new ProducerAndConsumerTest();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    p.put("生产的数据" + j);
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("消费：" + p.get());
        }
    }
}
