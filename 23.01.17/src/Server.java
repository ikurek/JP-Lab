import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by igor on 29.01.17.
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    public Server() throws RemoteException {

    }

    @Override
    public void GetStatus() throws RemoteException {
        System.out.println("Centrala.GetStatus()");
    }
}
