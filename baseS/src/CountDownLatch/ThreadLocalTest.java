package CountDownLatch;

import FanSheTest.Person;

public class ThreadLocalTest {
    static ThreadLocal<A> threadLocal = new ThreadLocal<A>();
    static A a;


    public static void main(String[] args) {
        new Thread(() -> {
            threadLocal.set(new A());
        }).start();

        new Thread(() -> {
            System.out.println(threadLocal.get());
        }).start();
    }

    static class A {
        String name = "123";
    }
}
