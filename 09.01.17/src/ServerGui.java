import javax.swing.*;
import java.util.ArrayList;

//GUI dla serwera
class ServerGui extends JFrame {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel panel = new JPanel();
    private Server server;

    ServerGui(Server server) {
        super("Server");
        this.server = server;
        setSize(300, 340);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel);
        setVisible(true);
    }

    //Tworzy guzik dla nowej bramki na serwerze
    void addGateway(String nick) {
        JButton b = new JButton(nick);
        b.addActionListener(e -> server.changeStateOfGateway(b.getText()));
        buttons.add(b);
        panel.add(b);
        panel.revalidate();
        panel.repaint();
    }

    void kill() {
        setVisible(false);
        dispose();
    }
}
