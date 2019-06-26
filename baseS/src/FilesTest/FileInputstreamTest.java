package FilesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputstreamTest {
    public static void main(String[] args) throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        InputStream is = new FileInputStream(file);
        byte temp[] = new byte[1024];
        int len = is.read(temp);
        System.out.println("{" + new String(temp, 0, len) + "}");
        is.close();
    }
}
