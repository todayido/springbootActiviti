package DemoTest;

import java.math.BigDecimal;

public class BigDeicimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("6565989895223");
        BigDecimal b = new BigDecimal("12321");
        System.out.println(a.add(b));

        BigDecimal[] result = a.divideAndRemainder(b);
        System.out.println("商：" + result[0] + " 余数：" + result[1]);
    }
}
