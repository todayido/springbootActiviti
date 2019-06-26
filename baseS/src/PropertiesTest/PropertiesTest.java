package PropertiesTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("hello", "HELLO-你好");
        properties.store(new FileOutputStream(new File("a.propteris")), "注释内容");
        System.out.println(properties.get("hello"));
    }
}
