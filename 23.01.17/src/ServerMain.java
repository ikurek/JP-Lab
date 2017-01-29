import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by igor on 29.01.17.
 */
public class ServerMain {

    ServerMain() {
        try {
            System.out.println("Startuje serwer...");
            Registry reg = LocateRegistry.createRegistry(1099);
            Bramka bramka = new Bramka();
            Server server = new Server();
            reg.rebind("bramka", bramka);
            reg.rebind("server", server);
            System.out.println("Serwer gotowy!");

            while(true){
                System.out.println(bramka.GetStatus());
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerMain();
    }


}
