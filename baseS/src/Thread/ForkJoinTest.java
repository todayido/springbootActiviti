package Thread;

import java.util.Arrays;
import java.util.Random;

public class ForkJoinTest {

    static int[] data = new int[1000000];

    static {
        for (int i = 0; i < data.length; i++) {
            data[i] = new Random().nextInt(100);
        }

        System.out.println(Arrays.stream(data).sum());
    }

    public static void main(String[] args) {
    }
}
