package Thread;

import java.util.concurrent.atomic.AtomicLong;

public class TestAtomic {
    private AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

    public void setCount() {
        count.set(1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                new TestAtomic().setCount();
                System.out.println(new TestAtomic().getCount());
            }).start();
        }
    }
}
