import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


//Zawiera definicję obiektu bramki implementującego runnable
public class Gateway implements Runnable {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private int gatewayCounter = 0;
    private boolean gatewayBlocked = false;
    private String nick;
    private Server server;
    private volatile boolean kill = false;

    //Konstruktor przyjmuje Server i gniazdo
    //W momencie utworzenia rozpoczyna wątek
    Gateway(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    //Zwraca nazwę bramki
    String getNick() {
        return nick;
    }

    //Zwraca wejście do bramki
    ObjectInputStream getInput() {
        return input;
    }

    //TODO: Zdublowana funkcja z getNick()!!!
    public String toString() {
        return nick;
    }

    //Blokuje lub odblokowuje bramkę
    void changeStateOfGateway() {
        gatewayBlocked = !gatewayBlocked;
    }

    //Sprawdza czy bramka jest zablokowana
    boolean isGatewayBlocked() {
        return gatewayBlocked;
    }

    //Zwraca licznik przejść na bramce
    int getGatewayCounter() {
        return gatewayCounter;
    }

    //Wykonuje się w momencie uruchomienia wątku
    //Sprawdza czy nick nie jest zajęty, czy jest odpowiedni monitor etc.
    //Jezeli wszystko jest ok dodaje bramkę do servera
    public void run() {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            nick = (String) input.readObject();
            if (server.isNickTaken(nick)) {
                output.writeObject("$TAKEN$");
                input.close();
                output.close();
                socket.close();
                socket = null;
                return;
            } else if (nick.equals("$MONITOR$")) {
                server.addMonitor(this);
                while (!kill) server.useMonitor(this);
                input.close();
                output.close();
                socket.close();
                socket = null;
                return;
            }
            server.addClient(nick, this);
            while (!kill) server.useCommand(this);
            server.deleteClient(this);
            input.close();
            output.close();
            socket.close();
            socket = null;
        } catch (Exception ignored) {
        }
    }

    //Zwiększa o 1 licznik przejść na bramce
    void addOne() {
        gatewayCounter++;
    }

    //Funkcja wysyła string do klienta
    void out(String s) {
        try {
            output.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
