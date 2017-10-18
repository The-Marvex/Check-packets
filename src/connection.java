import java.io.*;
import java.net.Socket;

public class connection extends Thread {

    Socket server;

    public connection(Socket connected_server) {
        this.server = connected_server;
    }


    @Override
    public void run() {
        start_conversation(server);
    }


    private void start_conversation(Socket server_socket){
        try {
            DataInputStream input_reader = new DataInputStream(server_socket.getInputStream());
            DataOutputStream output_reader = new DataOutputStream(server_socket.getOutputStream());
            System.out.println("Sending message ...");
            output_reader.writeUTF("Hello from server");
            System.out.println("Recieved ...");
        }

        catch (IOException e){
            System.out.println("Error in connection from server side, try again...");
        }
    }
}
