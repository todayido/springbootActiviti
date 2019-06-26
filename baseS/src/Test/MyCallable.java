package Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    int i = 100;

    @Override
    public String call() throws Exception {
        for (int i1 = 0; i1 < 100; i1++) {
            System.out.println(i--);
        }
        return "循环结束了";
    }

    public static void main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}
