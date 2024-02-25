import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 12345); // Connect to server on port 12345

        System.out.println("Connected to server...");

        // Send message to server
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello from client!");

        // Read response from server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();

        System.out.println("Received message from server: " + message);

        clientSocket.close(); // Close connection
    }
}
