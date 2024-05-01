package CHAT;
import java.net.*;

public class Server {

    public static void main(String[] args)throws Exception {
        ServerSocket s=new ServerSocket(4000);
        while (true) {    
            Socket c=s.accept();  
            ClientHandle c1=new ClientHandle(c);
            c1.start();      
        }
        

    }
}