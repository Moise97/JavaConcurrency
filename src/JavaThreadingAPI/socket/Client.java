package JavaThreadingAPI.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A Java program for a Client
 */

public class Client {

    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    // constructor to put ip address and port
    public Client(String address, int port) {

        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());

        } catch (IOException u) {
            u.printStackTrace();
        }

        // String to read message from input
        String line = "";

        // keep reading until "Over" is input
        while(!line.equals("Over")) {
            try {
                assert null != input;
                line = input.readLine();
                assert null != output;
                output.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // close the connection
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Client client = new Client("127.0.0.1", 5000);
    }

}
