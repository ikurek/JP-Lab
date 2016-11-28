import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 28.11.16.
 */
public class MainWindow extends JFrame {
    private JPanel mainWindowJPanel;
    private JButton exitButton;
    private JButton startStopButton;
    private JPanel drawFieldJPanel;

    public MainWindow(){
        super("Gra 0.1");
        setContentPane(mainWindowJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                dispose();
            }
        });
    }
}
