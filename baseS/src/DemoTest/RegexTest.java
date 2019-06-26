package DemoTest;

import java.util.ResourceBundle;

public class RegexTest {
    public static void main(String[] args) {
        String str = "123";
        if (str.matches("\\d+")) {
            int num = Integer.parseInt(str);
            System.out.println(num * 2);
        }

        str = "aab";
        String regex = "(a|b){2,}";
        System.out.println(str.matches(regex));

    }
}
