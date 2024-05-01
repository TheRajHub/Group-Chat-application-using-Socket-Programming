package CHAT;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandle extends Thread {
    private Socket c1;
    private Scanner inFromClient;
    static List<Socket> ClientList = new ArrayList<>();

    ClientHandle(Socket c) throws Exception {
        this.c1 = c;
        this.inFromClient = new Scanner(new InputStreamReader(c1.getInputStream()));
        ClientList.add(this.c1);

    }

    public void run() {
        try {
            System.out.println("Connected to " + c1.getPort());
            while (true) {
                String d = inFromClient.nextLine();
                System.out.println(d);
                broadCast(c1.getPort(), d);
            }
        } catch (NoSuchElementException a) {
            System.out.println("Client Disconnected...");
            ClientList.remove(c1);
            try {
                c1.close();
                inFromClient.close();
            } catch (IOException q) {

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void broadCast(int s, String d) throws Exception {
        for (int i = 0; i < ClientHandle.ClientList.size(); i++) {
            Socket f = ClientHandle.ClientList.get(i);
            if (!(f.getPort() == s)) {
                DataOutputStream toclient = new DataOutputStream(f.getOutputStream());
                toclient.writeBytes(d + "\n");
            }

        }
    }
}
