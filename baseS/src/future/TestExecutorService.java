package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {
    static class Job implements Runnable {

        @Override
        public void run() {
            doWork();
        }

        private void doWork() {
            System.out.println("doing...");
        }
    }

    public static void main(String[] args) throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(5000);
//            executorService.execute(new Job());
//        }

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().setName("i" + finalI);
                System.out.println(Thread.currentThread().getName());
            }).start();

        }
    }
}
