import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Listen on port 12345

        System.out.println("Server started on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Wait for client connection

            System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress());

            // Read data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();

            System.out.println("Received message from client: " + message);

            // Send response to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello from server!");

            clientSocket.close(); // Close client connection
        }
    }
}
