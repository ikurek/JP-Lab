import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by igor on 29.01.17.
 */
public interface BramkaInterface extends Remote {

    String GetStatus() throws RemoteException;

    int GetNumber() throws RemoteException;

    void SetStatus() throws RemoteException;

    void SetNumber(int number) throws RemoteException;
}
