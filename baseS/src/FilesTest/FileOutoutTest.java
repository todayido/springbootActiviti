package FilesTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutoutTest {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "hello.txt");

        // 是否自动关闭，取决于项目架构。
        try (OutputStream outputStream = new FileOutputStream(file, true)) {
            String str = "test file output stream...\r\n";
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
