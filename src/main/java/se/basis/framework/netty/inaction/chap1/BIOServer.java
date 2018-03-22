package se.basis.framework.netty.inaction.chap1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/11/8.
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        int count = 0;
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content = reader.readLine();
            count++;
            System.out.println("Server accepted msg:" + content + ", count :" + count);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello client");
            writer.flush();
        }
    }
}
