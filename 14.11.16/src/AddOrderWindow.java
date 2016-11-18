import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 18.11.16.
 */

//Klasa zawiera okno dodawania zamówień
    //TODO: rozwiązać problem przechowywania zamówienia po dodaniu
public class AddOrderWindow extends JFrame {
    private JButton cancelButton;
    private JButton addButton;
    private JPanel AddOrderJPanel;
    private JTextField priceTextField;
    private JTextField adresTextField;
    private JTextField timeTextField;
    private JTextField statusTextField;
    private JLabel priceLabel;
    private JLabel adresLabel;
    private JLabel timeLabel;
    private JLabel statusLabel;
    private JTextField numberTextField;
    private JLabel numberLabel;


    public AddOrderWindow(){

        //Konfiguracja okna dodawania zamówień
        super("Dodaj zamówienie");
        setContentPane(AddOrderJPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        //Listenery do przycisków
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddOrderWindow.super.dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                readUserInput();
            }
        });
    }



    public String[] readUserInput() {

        String[] data = {priceLabel.getText(), adresLabel.getText(), timeLabel.getText(), statusLabel.getText()};

        return data;

    }
}
