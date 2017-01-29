import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by igor on 29.01.17.
 */
public class Bramka extends UnicastRemoteObject implements BramkaInterface {

    public Bramka() throws RemoteException {

    }

    @Override
    public String GetStatus() throws RemoteException {
        System.out.println("Bramka zwróciłą status");
        return "GetStatus done";
    }

    @Override
    public int GetNumber() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetStatus() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
