import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String [] args){

    }

    private ServerSocket set_server_socket(int port_no){
        ServerSocket server_socket = null;
        try{
            server_socket = new ServerSocket(port_no);
        }
        catch (IOException e){
            System.out.println("Error in creating server socket, try again...");
        }
        return server_socket;
    }

    private Socket get_connection_socket(ServerSocket server_socket){
        Socket connection = null;
        try {
            connection = server_socket.accept();
            System.out.println("Successfully connected to : ");
            System.out.println(server_socket.getInetAddress());
        }
        catch (IOException e){
            System.out.println("Error in connection from server side, try again...");
        }
        return connection;
    }
}
