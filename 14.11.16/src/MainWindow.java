import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by igor on 17.11.16.
 */

//Klasa zawiera okno dialogowe i listgenery przycisków
public class MainWindow extends JFrame {

    //Zmienne klasowe
    public ArrayList<Order> listOfOrders = new ArrayList<>();
    public ProcessOrder processOrder = new ProcessOrder();
    public JDialog pizzaSelector = new PizzaSelector();

    //Elementy UI
    public DefaultTableModel model;
    private JButton exitButton;
    private JButton addOrderButton;
    private JTable mainTable;
    private JPanel mainWindowJPanel;
    private JScrollPane tableJScrollPane;
    private JButton logButton;


    public MainWindow() {
        super("Pizza 1.3");

        //Konfiguracja tabeli
        this.model = new DefaultTableModel(new Object[][]{},
                new Object[]{"Numer Telefonu", "Adres", "Pizza", "Cena", "Kierowca", "Status", "Godzina Zamówienia"});


        mainTable.setModel(this.model);

        //Konfiguracja okna dialogowego
        setContentPane(mainWindowJPanel);
        tableJScrollPane.setViewportView(mainTable);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
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

                saveUserOrder();

            }
        });
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String log = processOrder.generateLog(listOfOrders);
                System.out.print(log);
                JOptionPane.showMessageDialog(new Frame(), log, "Statystyka",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });
    }


    //Zapisuje zamówienie z osobnego okna
    //Przypisuje kierowcę i datę zamówienie
    public void saveUserOrder() {
        String driver = "";
        String date = "";
        Order order;


        System.out.println("Selector dialog created");
        order = new PizzaSelector().showDialogForResult();
        System.out.println("Selector dialog returned ");

        //Przypisuje kierowcę do obiektu order
        //Wymaga danych z obiektu order, dlatego taka śmieszna konstukcja
        driver = processOrder.assignDriver(order);
        order.setDriver(driver);

        date = processOrder.assignDate();
        order.setDateOfOrder(date);

        //dodaje obiekt order do listy
        this.listOfOrders.add(order);

        //Tworzy string i dodje go do tabeli
        String[] orderStringArray = processOrder.parseOrderToStringArray(order);
        this.model.addRow(orderStringArray);

    }


}