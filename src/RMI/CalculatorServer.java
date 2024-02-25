package RMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            RemoteCalculatorImpl calculator = new RemoteCalculatorImpl();

            // Create the registry at port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            registry.rebind("Calculator", calculator);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
