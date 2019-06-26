package Thread;

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        System.out.println("start");

        Thread t1 = new Thread(() -> {
            System.out.println("1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("2");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("3");
        });

        //让线程按照顺序执行
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println("end");
    }
}
