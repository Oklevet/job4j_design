package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerBot {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    StringBuilder response = new StringBuilder();
                    boolean work = true;
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.startsWith("GET") && str.contains("=")) {
                            String[] arrStr = str.split("=");
                            String s = arrStr[1].substring(0, arrStr[1].indexOf(" "));
                            switch (s) {
                                case ("Hello"):
                                    response.append("Hello, dear friend");
                                    break;
                                case ("Exit"):
                                    response.append("Завершить работу сервера.");
                                    work = false;
                                    break;
                                default:
                                    response.append("Введенная команда не распознана.");
                                    break;
                            }
                        }
                        str = in.readLine();
                    }
                    System.out.println(response.toString());
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write((response.toString() + "\r\n").getBytes());
                    if (!work) {
                        server.close();
                    }
                } catch (Exception e) {
                    LOG.error("Exception in log example", e);
                }
            }
        }
    }
}