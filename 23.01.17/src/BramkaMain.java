import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by igor on 29.01.17.
 */
public class BramkaMain {


    BramkaMain() {
        try {
            System.out.println("Startuje bramka...");
            Registry myReg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            BramkaInterface m = (BramkaInterface) myReg.lookup("bramka");
            ServerInterface n = (ServerInterface) myReg.lookup("server");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BramkaMain();
    }
}
