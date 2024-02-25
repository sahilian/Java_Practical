package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCalculatorImpl extends UnicastRemoteObject implements RemoteCalculator {
    public RemoteCalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
