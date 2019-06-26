package SocketTest;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待客户端连接...");
        Socket client = serverSocket.accept();
        Scanner scanner = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());

        boolean flag = true;
        while (flag) {
            System.out.println("=====");
            if (scanner.hasNext()) {
                String val = scanner.next().trim();
                if (val.equalsIgnoreCase("bye")) {
                    System.out.println("bye bye ...");
                    flag = false;
                } else {
                    out.println("echo " + val);
                    out.flush();
                }
            }
        }

        scanner.close();
        out.close();
    }
}
