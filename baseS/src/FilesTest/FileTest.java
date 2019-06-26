package FilesTest;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        System.out.println(File.separator);
        File file = new File("D:" + File.separator);
        listDir(file);
    }

    public static void listDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    listDir(files[i]);
                }
            }
        } else {
            System.out.println(file);
        }
    }
}
