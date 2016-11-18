import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 17.11.16.
 */

//Klasa zawiera okno dialogowe i listgenery przycisków
public class MainWindow extends JFrame {
    private JButton exitButton;
    private JButton addOrderButton;
    private JTable mainTable;
    private JPanel mainWindowJPanel;
    private JScrollPane tableJScrollPane;


    public MainWindow() {
        super("Pizza 1.0");

        //Konfiguracja tabeli
        String[] tableColumnNames = {"Numer", "Godzina", "Cena", "Adres", "Kierowca", "Status"};
        Object[][] data = {{"1", "12:00", "25,00", "Ulica 1", "Andrzej", "Zakończone"}, {"2", "13:00", "29,00", "Ulica 2", "Krzysztof", "Przygotowywanie"}};
        mainTable = new JTable(data, tableColumnNames);

        //Konfiguracja okna dialogowego
        setContentPane(mainWindowJPanel);
        tableJScrollPane.setViewportView(mainTable);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 640);
        setLocationRelativeTo(null);


        setVisible(true);

        //Listenery do przycisków
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                System.exit(0);
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Pokaż okno dodania zamówienia
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AddOrderWindow();
                    }
                });

            }
        });
    }
}
