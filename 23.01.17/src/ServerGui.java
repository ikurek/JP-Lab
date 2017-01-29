import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//GUI dla serwera
class ServerGui extends JFrame {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel panel = new JPanel();
    private ServerMain server;

    ServerGui(ServerMain server) {
        super("Server");
        this.server = server;
        setSize(300, 340);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addGateway("Bramka");
        setContentPane(panel);
        setVisible(true);
    }

    //Tworzy guzik dla nowej bramki na serwerze
    void addGateway(String nick) {
        JButton b = new JButton(nick);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               server.changeShouldGetValue();
               System.out.println("Button pressed");
            }
        });
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
