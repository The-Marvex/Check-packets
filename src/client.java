import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        Scanner alpha = new Scanner(System.in);
        System.out.println("Enter the IP of server you want to connect to...");
        String server_IP = alpha.next();
        System.out.println("Enter the port no of server for connection...");
        int port_no = alpha.nextInt();
        Socket client = new client().get_socket(server_IP,port_no);
        try {
            BufferedInputStream input_reader = new BufferedInputStream(client.getInputStream());
            BufferedOutputStream output_reader = new BufferedOutputStream(client.getOutputStream());
        }
        catch (IOException e){
            System.out.println("Error in getting input stream....");
        }
        




    }

    private Socket get_socket(String server_IP, int port_no){
        Socket client_socket = null;
        try{
            client_socket = new Socket(server_IP,port_no);
            System.out.println("Successfully connected to : ");
            System.out.println(client_socket.getInetAddress());
        }
        catch (IOException e){
            System.out.println("Error in connection form client side, try again...");
        }
        return client_socket;
    }

}
