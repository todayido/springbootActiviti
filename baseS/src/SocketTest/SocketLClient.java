package SocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class SocketLClient {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 9999);
        Scanner scanner = new Scanner(client.getInputStream());
        scanner.useDelimiter("\n");
        PrintStream outW = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            String input = getString("请输入内容:").trim();
            outW.println(input);
            if (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }

        scanner.close();
        outW.close();
        client.close();
    }

    public static String getString(String prompt) throws Exception {
        System.out.print(prompt);
        String str = input.readLine();
        return str;
    }
}
