package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> methodA());// 业务A
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> methodB());// 业务B
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> methodC());// 业务C

        try {
            System.out.println(futureA.get() + futureB.get() + futureC.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(methodA() + methodB() + methodC());
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - end);
    }

    private static <U> String methodA() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodA...";
    }

    private static <U> String methodB() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodB...";
    }

    private static <U> String methodC() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodC...";
    }
}
