import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class driving_server {
    public static void main(String [] args){
        ServerSocket server = new driving_server().set_server_socket(5500);
        System.out.println("Waiting for clients ...");
        while(true){
            try{
                Socket connected_server = server.accept();
                System.out.println("Just connected to : ");
                System.out.println(connected_server.getRemoteSocketAddress());
                Thread t = new connection(connected_server);
                t.start();
            }
            catch (IOException e){
                System.out.println("Error in connection from server side ...");
            }
        }
    }

    public ServerSocket set_server_socket(int port_no){
        ServerSocket server_socket = null;
        try{
            server_socket = new ServerSocket(port_no);
        }
        catch (IOException e){
            System.out.println("Error in creating server socket, try again...");
        }
        return server_socket;
    }
}
