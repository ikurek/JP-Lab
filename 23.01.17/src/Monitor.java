import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//Obiekt implementuje runnable
//Zlicza liczbę przejść przez bramkę
public class Monitor implements Runnable {

    private static final int SERVER_PORT = 15000;
    private MonitorGui gui = new MonitorGui();
    private MonitorClock monitorClock;
    private String host;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean kill = false;

    //Konstruktor tym razem bez parametryzacji
    Monitor() {
        (new Thread(this)).start();
    }


    //Towrzy socket monitora, odbiera dane o przejściu przez bramkę
    //uruchamia się w momencie utworzenia obiektu

    //Main dla monitora
    public static void main(String[] args) {
        new Monitor();
    }

    public void run() {
        try {
            host = InetAddress.getLocalHost().getHostName();
            socket = new Socket(host, SERVER_PORT);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject("$MONITOR$");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Polaczenie sieciowe dla klienta nie moze byc utworzone");
            kill();
            return;
        }
        monitorClock = new MonitorClock(this);
        try {
            while (!kill) {
                String s = (String) input.readObject();
                String nick = "error", value = "error";
                if (s.equals("$START$")) {
                    s = (String) input.readObject();
                    while (!s.equals("$END$")) {
                        value = s.substring(s.indexOf("$") + 1, s.length());
                        nick = s.substring(0, s.indexOf("$"));
                        gui.addGateway(nick, value);
                        s = (String) input.readObject();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Polaczenie sieciowe dla klienta zostalo przerwane");
            kill();
        }
    }

    //Ping
    //Pong
    void ping() {
        try {
            output.writeObject("$PING$");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Zakańcza pracę monitora
    private void kill() {
        if (monitorClock != null) monitorClock.kill();
        gui.kill();
    }
}
