package DeadLock;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    public static void main(String[] args) {

        Thread.currentThread().setName("Test Dead Lock");

        String str1 = "lock";
        String str2 = "dead";

        new Thread(new DeadLockThead(str1, str2), "deadLock001").start();
        new Thread(new DeadLockThead(str2, str1), "deadLock002").start();
        try {
            TimeUnit.MILLISECONDS.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class DeadLockThead implements Runnable {
    String str1;
    String str2;

    public DeadLockThead(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {
        synchronized (str1){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str2){
                System.out.println("running......");
            }
        }
    }
}
