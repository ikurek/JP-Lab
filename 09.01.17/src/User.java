import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class User implements Runnable {
    private static final int SERVER_PORT = 15000;
    private UserClock userClock = new UserClock(this);
    private UserGui gui;
    private String nick;
    private String host;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean kill = false;
    private int currentFrequency = 1000;
    private boolean gatewayBlocked = false;

    User(String nick) {
        this.nick = nick;
        (new Thread(this)).start();
    }

    public static void main(String[] args) {
        String nick;

        nick = JOptionPane.showInputDialog("Podaj nazwe klienta");
        if (nick != null && !nick.equals("")) {
            new User(nick);
        }
    }

    //Tworzy socket kliencki i łączy się z serwerem
    //Sprawdza czy bramka jest otwarta oraz czy nick nie jest zajęty
    public void run() {
        try {
            host = InetAddress.getLocalHost().getHostName();
            socket = new Socket(host, SERVER_PORT);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(nick);
            gui = new UserGui(nick, Integer.toString(socket.getPort()), host, this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Polaczenie sieciowe dla klienta nie moze byc utworzone");
            kill();
            return;
        }
        try {
            while (!kill) {
                String s = (String) input.readObject();
                switch (s) {
                    case "$BLOCKED$":
                        gui.append("Brama ma status: " + s);
                        gatewayBlocked = true;
                        gui.gatewayStatus(gatewayBlocked);
                        userClock.freeze();
                        break;
                    case "$OPEN$":
                        gui.append("Brama ma status: " + s);
                        gatewayBlocked = false;
                        gui.gatewayStatus(gatewayBlocked);
                        break;
                    case "$TAKEN$":
                        System.err.println("Nick zajęty! Konczenie programu dla nicku: " + nick);
                        JOptionPane.showMessageDialog(
                                null,
                                "Nick zajęty! Kończenie programu.",
                                "Nick zajęty!",
                                JOptionPane.ERROR_MESSAGE);
                        kill();
                        return;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Polaczenie sieciowe dla klienta zostalo przerwane");
            kill();
        }
    }

    //Wysyłą sygnał przejścia przez bramkę
    //$GO$
    void go() {
        try {
            output.writeObject("$GO$");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Automatycznie wysyła sygnał przejścia przez bramke co jakiś czas
    void goAuto() {
        userClock.changeFreezeState();
    }

    //Zbiera aktualną częstotliwość automatycznego przesyłu
    //Potrzebne do aktualizowania jeżeli user zmieni częstotliwość
    int getCurrentFrequency() {
        return currentFrequency;
    }

    //Ustawia częstotliwość wysyłania automatycznego sygnału przejścia
    void setCurrentFrequency(int i) {
        currentFrequency = i;
    }

    private void kill() {
        if (userClock != null) userClock.kill();
        gui.kill();
    }
}

