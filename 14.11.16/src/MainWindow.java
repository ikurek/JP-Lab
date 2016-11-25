import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by igor on 17.11.16.
 */

//Klasa zawiera okno dialogowe i listgenery przycisków
public class MainWindow extends JFrame {
    public ArrayList<Order> listOfOrders = new ArrayList<>();
    public ProcessOrder processOrder;
    public DefaultTableModel model;
    private JButton exitButton;
    private JButton addOrderButton;
    private JTable mainTable;
    private JPanel mainWindowJPanel;
    private JScrollPane tableJScrollPane;
    private JTextField numberTextField;
    private JTextField adresTextFiels;
    private JTextField pizzaTextField;
    private JTextField priceTextField;
    private Object[][] data;


    public MainWindow() {
        super("Pizza 1.1");

        //Konfiguracja tabeli
        this.model = new DefaultTableModel(new Object[][]{},
                new Object[]{"Numer", "Adres", "Pizza", "Cena", "Kierowca", "Status"});


        mainTable.setModel(this.model);

        //Konfiguracja okna dialogowego
        setContentPane(mainWindowJPanel);
        tableJScrollPane.setViewportView(mainTable);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
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
                clearTextFields();

            }
        });
    }


    public void saveUserOrder() {
        //Przechwytuje text z jTextField
        String number, pizza, adress, price;
        number = numberTextField.getText();
        pizza = pizzaTextField.getText();
        adress = adresTextFiels.getText();
        price = priceTextField.getText();

        //Tworzy nowy obiekt typu Order i zapisuje do listy
        Order order = new Order(number, adress, pizza, price, "Andrzej", "W trakcie");
        this.listOfOrders.add(order);

        //Tworzy string i dodje go do tabeli
        String[] orderStringArray = {number, pizza, price, adress, "Andrzej", "W trakcie"};
        this.model.addRow(orderStringArray);

    }

    public void clearTextFields() {

        numberTextField.setText("");
        pizzaTextField.setText("");
        adresTextFiels.setText("");
        priceTextField.setText("");

    }

}