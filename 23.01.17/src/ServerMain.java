import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static java.lang.Thread.sleep;

/**
 * Created by igor on 29.01.17.
 */
public class ServerMain implements Runnable {
    public Boolean shouldGetValue = false;
    public Boolean kill = false;
    Bramka bramka;
    Server server;

    ServerMain() {
        new Thread(this).start();
        System.out.println("ServerMain finished");
    }

    public static void main(String[] args) {
        new ServerMain();
    }

    public void changeShouldGetValue() {
        System.out.println("Changevalue called");
        this.shouldGetValue = !shouldGetValue;
    }

    //Przygotowuje połączenie z bramką
    //Startuje GUI
    //Uruchamia wątek który utrzymuje w pętli RMI
    public void run() {
        try {
            System.out.println("Startuje serwer...");
            Registry reg = LocateRegistry.createRegistry(1099);
            bramka = new Bramka();
            server = new Server();
            reg.rebind("bramka", bramka);
            reg.rebind("server", server);
            System.out.println("Serwer gotowy!");
            ServerGui serverGui = new ServerGui(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Uruchamianie pętli serwerowej...");
        while (!kill) {
            if(shouldGetValue){
                try{
                    System.out.println(bramka.GetStatus());
                    this.shouldGetValue = false;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
            //Śleep na sekundę
            //Potrzebny żeby mogła się zmienić wartość zwracająca value
            //TODO: Jestem złym człowiekiem, i jeszcze gorszym programistą
            try{
                sleep(1000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}
