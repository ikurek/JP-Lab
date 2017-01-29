import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by igor on 29.01.17.
 */
public class Bramka extends UnicastRemoteObject implements BramkaInterface {

    String status = "Otwarta";
    Integer number = 0;

     Bramka() throws RemoteException {

    }

    @Override
    public String GetStatus() throws RemoteException {
        return status;
    }

    @Override
    public int GetNumber() throws RemoteException {
        return number;
    }

    @Override
    public void SetStatus() throws RemoteException {
        if(status=="Otwarta") status = "Zamknięta";
        else if(status=="Zamknięta") status = "Otwarta";
    }

    public void SetNumber(int number) throws RemoteException {
         this.number=number;
    }
}
