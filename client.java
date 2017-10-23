import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        Scanner alpha = new Scanner(System.in);
        String server_IP = "192.168.43.238";
        int port_no = 5500;
        Socket client = new client().get_socket(server_IP,port_no);

        try {
            DataInputStream input_stream = new DataInputStream(client.getInputStream());
            DataOutputStream output_stream = new DataOutputStream(client.getOutputStream());
            BufferedReader console_reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = "";
            while (msg!="exit"){
                System.out.println(input_stream.readUTF());
                msg = console_reader.readLine();
                output_stream.writeUTF(msg);
            }
            client.close();
            System.out.println("Connection terminated ...");
        }
        catch (IOException e){
            System.out.println("Error in getting input stream...");
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
