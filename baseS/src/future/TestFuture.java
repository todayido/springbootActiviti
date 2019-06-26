package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFuture {

    public static Object loadData() {
        return "do something....";
    }

    static class Job<Object> implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            return (Object) loadData();
        }
    }

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new Job<Object>());
        new Thread(futureTask).start();

        // dp sonthing else
        Object result = futureTask.get();
    }

}
