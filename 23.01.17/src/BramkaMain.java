import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by igor on 29.01.17.
 */
public class BramkaMain implements Runnable {

    public Boolean kill = false;
    public String status = "Otwarta";
    BramkaInterface bramkaInterface;
    ServerInterface serverInterface;
    int number = 0;

    BramkaMain() {
        new Thread(this).start();
    }

    public static void main(String[] args) {
        new BramkaMain();
    }


    public void run() {
        try {
            System.out.println("Startuje bramka...");
            Registry myReg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            bramkaInterface = (BramkaInterface) myReg.lookup("bramka");
            serverInterface = (ServerInterface) myReg.lookup("server");
            BramkaGui bramkaGui = new BramkaGui(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Uruchamianie pętli bramki...");
        while (!kill) {
            try{
                bramkaInterface.SetNumber(this.number);
                status = bramkaInterface.GetStatus();
            }catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }
}
