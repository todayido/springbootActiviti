package DemoTest;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("我被执行了......");
            }
        };

        System.out.println(System.currentTimeMillis());
        Timer timer = new Timer();
        timer.schedule(timerTask, 5000, 1000);
    }
}
