import javax.swing.*;

//Odpowiada za GUI bramki
class UserGui extends JFrame {

    private JButton
            buttonGo = new JButton("Przejdź przez bramkę"),
            buttonAuto = new JButton("Automat"),
            buttonAbout = new JButton("Debug");
    private JSlider frequency = new JSlider(0, 100, 10000, 1000);

    private JTextArea errors = new JTextArea(15, 30);
    private JScrollPane scrollPane;

    {
        scrollPane = new JScrollPane(errors, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    UserGui(String nick, String port, String host, User user) {
        super(nick + " " + host + " " + port);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.add(buttonGo);
        panel.add(buttonAuto);
        panel.add(buttonAbout);
        panel.add(frequency);
        panel.add(scrollPane);
        setVisible(true);
        buttonGo.addActionListener(e -> user.go());
        buttonAuto.addActionListener(e -> user.goAuto());
        frequency.addChangeListener(e -> user.setCurrentFrequency(frequency.getValue()));
        buttonAbout.addActionListener(e -> JOptionPane.showMessageDialog(null, "Było potrzebne do debugu ;-)"));
    }

    void kill() {
        setVisible(false);
        dispose();
    }

    void append(String string) {
        errors.append(string + "\n");
    }

    //sprawdza jaki status ma bramka (otwarty/zamknięty)
    //dostosowuje dostępność guzików
    void gatewayStatus(boolean gatewayBlocked) {
        if (gatewayBlocked) {
            buttonAuto.setEnabled(false);
            buttonGo.setEnabled(false);
        } else {
            buttonAuto.setEnabled(true);
            buttonGo.setEnabled(true);
        }
    }
}
