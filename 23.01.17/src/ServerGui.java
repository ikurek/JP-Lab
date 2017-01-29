import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//GUI dla serwera
class ServerGui extends JFrame {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JLabel numberLabel;
    private JPanel panel = new JPanel();
    private ServerMain server;

    ServerGui(ServerMain server) {
        super("Server+Monitor");
        this.server = server;
        setSize(300, 340);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addGateway();
        setContentPane(panel);
        setVisible(true);
    }

    //Tworzy guzik dla nowej bramki na serwerze
    void addGateway() {
        JButton getStatus = new JButton("getStatus()");
        JButton setStatus = new JButton("setStatus()");
        this.numberLabel = new JLabel("Przejścia przez bramkę: 0");

        getStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               server.changeShouldGetValue();
            }
        });

        setStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.changeShouldSetValue();
            }
        });
        buttons.add(getStatus);
        buttons.add(setStatus);
        panel.add(getStatus);
        panel.add(setStatus);
        panel.add(numberLabel);
        panel.revalidate();
        panel.repaint();
    }

    public void updateNumber(int number) {
        numberLabel.setText("Przejścia przez bramkę: " + number);
        panel.revalidate();
        panel.repaint();
    }

    void kill() {
        setVisible(false);
        dispose();
    }
}
