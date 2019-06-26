package DemoTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(date);

        long current = date.getTime();
        current += 864000000;//十天
        System.out.println(new Date(current));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(new Date()));

        String dateStr = "2019-13-19 24:10:10:111";
        System.out.println(sdf.parse(dateStr));
    }
}
