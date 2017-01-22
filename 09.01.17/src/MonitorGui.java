import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

//GUI monitora
//Jak sama nazwa wskazuje
class MonitorGui extends JFrame {
    private HashMap<String, String> values = new HashMap<>();
    private ArrayList<JLabel> labels = new ArrayList<>();
    private JPanel panel = new JPanel();

    MonitorGui() {
        super("Monitor");
        setSize(300, 340);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel);
        setVisible(true);
    }

    //Tworzy GUI dla nowej bramki
    //Jeżeli bramka o takiej same nazwie już istnieje to zastępuje starą
    void addGateway(String nick, String value) {
        if (values.containsKey(nick)) {
            values.replace(nick, value);
        } else {
            values.put(nick, value);
            JLabel l = new JLabel(nick + ": " + value);
            labels.add(l);
            panel.add(l);
        }
        panel.revalidate();
        panel.repaint();
        refresh();
    }

    private void refresh() {
        for (JLabel l : labels) {
            String s = l.getText().substring(0, l.getText().indexOf(":"));
            l.setText(s + ": " + values.get(s));
        }
        panel.revalidate();
        panel.repaint();
    }

    void kill() {
        setVisible(false);
        dispose();
    }
}
