package com.azhi.thread.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author azhi
 * 2021/3/31 12:50 下午
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        PrintWriter printWriter = null;
        BufferedReader reader = null;

        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 8000));
            printWriter = new PrintWriter(client.getOutputStream(), true);
            printWriter.write("hello");
            printWriter.flush();

            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("form server :" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
