import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class connection extends Thread {

    Socket server;
    Scanner alpha;

    public connection(Socket connected_server) {
        this.server = connected_server;
        alpha = new Scanner(System.in);
    }


    @Override
    public void run() {
        start_conversation(server);
    }


    private void start_conversation(Socket server_socket){
        try {
            DataInputStream input_stream = new DataInputStream(server_socket.getInputStream());
            DataOutputStream output_stream = new DataOutputStream(server_socket.getOutputStream());
            BufferedReader console_reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = "";
            while (msg!="exit"){
                msg = console_reader.readLine();
                output_stream.writeUTF(msg);
                System.out.println(input_stream.readUTF());
            }
            server_socket.close();
            System.out.println("Connection terminated ...");
        }

        catch (IOException e){
            System.out.println("Error in connection from server side, try again...");
        }
    }
}
