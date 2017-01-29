import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by igor on 28.01.17.
 */
public interface ServerInterface extends Remote {

    void GetStatus() throws RemoteException;
}
