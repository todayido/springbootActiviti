package Concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class FutrueTaskTest {
    public static void main(String[] args) {
        try {
            FutureTask<String> futureTask = new FutureTask(() -> {
                System.out.println("start");
                TimeUnit.MILLISECONDS.sleep(5000);
                System.out.println("end");
                return "hello";
            });

            //启动
            new Thread(futureTask).start();

            System.out.println("---------------");
            System.out.println(futureTask.get());
            System.out.println("===============");

            /** 返回结果如下：
             * ---------------
             * start
             * end
             * hello
             * ===============
             */


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
