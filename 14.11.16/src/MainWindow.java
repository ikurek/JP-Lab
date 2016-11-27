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

    //Elementy UI
    public DefaultTableModel model;
    private JButton exitButton;
    private JButton addOrderButton;
    private JTable mainTable;
    private JPanel mainWindowJPanel;
    private JScrollPane tableJScrollPane;
    private JButton logButton;
    private JPanel buttonsJPanel;
    private JButton buttonFinish;


    public MainWindow() {
        super("Pizza 1.3");

        //Konfiguracja tabeli
        this.model = new DefaultTableModel(
                new Object[][]{new Object[]{"012483081", "Ul. Wittiga 22, Wrocław", "Duża Margherita x1; ", "18,75", "Jarek", "Zakończone", "12:00"}},
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
        buttonFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer selectedRow = mainTable.getSelectedRow();
                System.out.println(selectedRow.toString());
                model.setValueAt("Zakończone", selectedRow, 5);

                Order selectedOrder = listOfOrders.get(selectedRow-1);
                selectedOrder.setIsFinished();



                listOfOrders.set((selectedRow-1), selectedOrder);
            }
        });
    }


    //Zapisuje zamówienie z osobnego okna
    //Przypisuje kierowcę i datę zamówienie
    public void saveUserOrder() {
        String driver = "";
        String date = "";
        Order order;


        //Pobiera obiekt klasy order z okna dialogowego
        order = new PizzaSelector().showDialogForResult();

        //Przypisuje kierowcę i datę do obiektu order
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