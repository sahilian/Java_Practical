package RMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Look up the remote object
            RemoteCalculator calculator = (RemoteCalculator) registry.lookup("Calculator");

            // Call remote method
            int result = calculator.add(10, 20);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
