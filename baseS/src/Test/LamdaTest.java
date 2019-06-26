package Test;

@FunctionalInterface
interface IMath {
    public int add(int a, int b);
//    public int minus(int a,int b);
}

class MyThread extends Thread {
    int tikets = 100;

    @Override
    public void run() {
        System.out.println("running...");
        super.run();
    }
}

public class LamdaTest {
    public static void main(String[] args) {
        IMath msg = (pa, pb) -> pa + pb;
        System.out.println(msg.add(1, 2));

        MyThread myThread = new MyThread();
        myThread.start();

    }


}
