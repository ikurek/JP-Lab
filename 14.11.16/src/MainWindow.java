import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    private AddOrderWindow addOrderWindow = new AddOrderWindow();
    private Object[][] data;


    public MainWindow() {
        super("Pizza 1.0");

        //Konfiguracja tabeli
        DefaultTableModel model = new DefaultTableModel(new Object[][] {
                {"Numer", "Godzina", "Cena", "Adres", "Kierowca", "Status"},
                {"Numer", "Godzina", "Cena", "Adres", "Kierowca", "Status"}},
                new Object[] {"Numer", "Godzina", "Cena", "Adres", "Kierowca", "Status"});


        mainTable.setModel(model);

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

                addOrderWindow.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent arg0) {
                        model.addRow(addOrderWindow.readUserInput());
                    }

                });

                //Pokaż okno dodania zamówienia
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addOrderWindow.setVisible(true);
                    }
                });

            }
        });
    }
}
