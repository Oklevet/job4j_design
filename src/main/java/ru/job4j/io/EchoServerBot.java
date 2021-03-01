package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerBot {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.startsWith("GET")) {
                            String[] arrStr = str.split("=");
                            String s = arrStr[1].substring(0, arrStr[1].indexOf(" "));
                            switch (s) {
                                case ("Hello"):
                                    out.write("Hello, dear friend.\r\n\r\n".getBytes());
                                    System.out.println("Hello, dear friend.");
                                    break;
                                case ("Exit"):
                                    out.write("Завершить работу сервера.\r\n\r\n".getBytes());
                                    System.out.println("Завершить работу сервера.");
                                    server.close();
                                    break;
                                default:
                                    out.write(s.getBytes());
                                    System.out.println(s);
                                    break;
                            }
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }
            }
        }
    }
}
