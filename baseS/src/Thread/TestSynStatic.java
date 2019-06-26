package Thread;

import java.util.concurrent.CountDownLatch;

public class TestSynStatic {

    /**
     *  当每个线程都new出来一个对象时，线程在执行时会创建自己的字段 i 和 add1 的副本，是线程安全的。
     *  当每个线程都共用new出来的一个对象时，不是线程安全的。
     */
    int i = 0;
    public void add1(){
        for (int i1 = 0; i1 < 100; i1++) {
            i++;
        }
        System.out.println("i:" + i);
    }

    /**
     *  存在在安全性问题, static 关键词修饰的变量会被线程共享，该变量 j 放在JVM的静态区域共享
     */
    static int j = 0;
    public void add2(){
        for (int i1 = 0; i1 < 100; i1++) {
            j++;
        }
        System.out.println("j:" + j);
    }

    /**
     *  存在在安全性问题, static 关键词修饰的变量，该变量 k 放在JVM的静态区域被多线程共享
     *  锁定的是新的实例
     *  当每个线程都共用new出来的一个对象时，是线程安全的。
     *  当每个线程都new出来一个对象时，不是线程安全的。
     */
    static int k = 0;
    public synchronized void add3(){
        for (int i1 = 0; i1 < 100; i1++) {
            k++;
        }
        System.out.println("k:" + k);
    }

    /**
     *  锁定的是JVM中的类，注意不是JVM中new出来的对象，线程安全
     */
    static int m = 0;
    public synchronized static void add4(){
        for (int i1 = 0; i1 < 100; i1++) {
            m++;
        }
        System.out.println("m:" + m);
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        TestSynStatic testSynStatic = new TestSynStatic();


        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
//                TestSynStatic testSynStatic = new TestSynStatic();
                testSynStatic.add1();
//                testSynStatic.add2();
//                testSynStatic.add3(); // 锁定的是新的实例，不是线程安全的。
//                testSynStatic.add4(); // 锁定的是JVM中的类，线程安全
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
