package CHAT;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connected to Group chat...");
        Socket c = new Socket("localhost", 4000);
        Scanner sc = new Scanner(System.in);
        DataOutputStream toserver = new DataOutputStream(c.getOutputStream());
        Scanner fromServer = new Scanner(new InputStreamReader(c.getInputStream()));
        try {
            new Thread(() -> {
                while (true) {
                    System.out.println(fromServer.nextLine());
                }
            }).start();
            while (true) {
                String a = sc.nextLine();
                toserver.writeBytes(a + "\n");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Disconneted From the Group chat....");

        }

    }
}