import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 29.01.17.
 */
public class BramkaGui extends JFrame {

    private JButton buttonGo = new JButton("Przejdź przez bramkę");
    JPanel panel = new JPanel();
    BramkaMain bramka;

    BramkaGui(BramkaMain bramka) {
        super("Bramka");
        setSize(400, 400);
        this.bramka = bramka;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel);
        panel.add(buttonGo);
        setVisible(true);
        buttonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(bramka.status.equals("Otwarta")) bramka.number++;
                else System.out.println("Bramka jest zablokowana!");
            }
        });
    }
}
