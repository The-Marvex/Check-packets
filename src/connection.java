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
            BufferedInputStream input_reader = new BufferedInputStream(server_socket.getInputStream());
            BufferedOutputStream output_reader = new BufferedOutputStream(server_socket.getOutputStream());
            System.out.println("Sending message ...");
            output_reader.write(new String("Hello from server").getBytes());
            System.out.println("Recieved ...");
        }

        catch (IOException e){
            System.out.println("Error in connection from server side, try again...");
        }
    }
}
