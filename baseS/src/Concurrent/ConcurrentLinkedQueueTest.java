package Concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {
    static Queue<String> queue = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            queue.add("票号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = queue.poll();// 原子操作，如果拿不到数据会继续判断while,所以不会出错，还能保证买票正确定。
                    if (s == null) {
                        break;
                    } else {
                        System.out.println(s);
                    }
                }
            }).start();
        }
    }
}
