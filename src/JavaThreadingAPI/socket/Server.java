package JavaThreadingAPI.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A Java Program for a Server
 */

public class Server {

    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    // constructor with port
    public Server(int port) {

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            // reads message from the client until "Over" is sent
            while(!line.equals("Over")) {

                line = input.readUTF();
                System.out.println(line);
            }

            // close the connection
            System.out.println("Closing connection");
            socket.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }

}
