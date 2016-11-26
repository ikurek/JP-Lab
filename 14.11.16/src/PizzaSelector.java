import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaSelector extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JComboBox sizeComboBox1;
    private JComboBox sizeComboBox2;
    private JComboBox sizeComboBox3;
    private JComboBox sizeComboBox4;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JTextField numberTextField;
    private JTextField adressTextField;
    private JLabel priceLabel1;
    private JLabel priceLabel2;
    private JLabel priceLabel3;
    private JLabel priceLabel4;

    public PizzaSelector() {
        //Konfiguracja okna
        super((java.awt.Frame) null, true);
        setTitle("Wybór pizzy");
        sizeComboBox1.setSelectedIndex(1);
        sizeComboBox2.setSelectedIndex(1);
        sizeComboBox3.setSelectedIndex(1);
        sizeComboBox4.setSelectedIndex(1);
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        pack();
        getRootPane().setDefaultButton(buttonOK);

        //Listenery
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                dispose();
            }
        });
        sizeComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                updatePricesOnSpinnerValueChange(selected, 1);
            }
        });
        sizeComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                updatePricesOnSpinnerValueChange(selected, 2);
            }
        });
        sizeComboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                updatePricesOnSpinnerValueChange(selected, 3);
            }
        });
        sizeComboBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                updatePricesOnSpinnerValueChange(selected, 4);
            }
        });
    }

    //Funkcja zwraca wybrane pizze jako string
    //w postaci pizzaxilość, pizzaxilość
    public Order showDialogForResult() {
        setVisible(true);
        String pizza = "";
        //Pobiera wartości ze spinnerów i comboboxów
        Integer ammountMargherita = (Integer) spinner1.getValue();
        String sizeMargherita = sizeComboBox1.getSelectedItem().toString();
        Integer ammountFunghi = (Integer) spinner2.getValue();
        String sizeFunghi = sizeComboBox2.getSelectedItem().toString();
        Integer ammountFarmerska = (Integer) spinner3.getValue();
        String sizeFarmerska = sizeComboBox3.getSelectedItem().toString();
        Integer ammountHawajska = (Integer) spinner4.getValue();
        String sizeHawajska = sizeComboBox4.getSelectedItem().toString();

        if (ammountMargherita > 0) {
            pizza = pizza + sizeMargherita + " Margherita x" + ammountMargherita + "; ";

        }
        if (ammountFunghi > 0) {
            pizza = pizza + sizeFunghi + " Funghi x" + ammountFunghi + "; ";

        }
        if (ammountFarmerska > 0) {
            pizza = pizza + sizeFarmerska + " Farmerska x" + ammountFarmerska + "; ";

        }
        if (ammountHawajska > 0) {
            pizza = pizza + sizeHawajska + " Hawajska x" + ammountHawajska + "; ";

        }

        Double price = Double.valueOf(priceLabel1.getText())*ammountMargherita + Double.valueOf(priceLabel2.getText())*ammountFunghi + Double.valueOf(priceLabel3.getText())*ammountFarmerska + Double.valueOf(priceLabel4.getText())*ammountHawajska;

        Order order = new Order(numberTextField.getText(), adressTextField.getText(), pizza, price.toString(), "Brak", "W toku", "00:00");

        return order;

    }

    public void updatePricesOnSpinnerValueChange(Object selected, Integer comboboxnumber) {

        JLabel label = new JLabel();
        Double price = 0.00;

        switch (comboboxnumber) {

            case 1:
                label = priceLabel1;
                price = 15.00;
                break;

            case 2:
                label = priceLabel2;
                price = 18.00;
                break;

            case 3:
                label = priceLabel3;
                price = 20.00;
                break;

            case 4:
                label = priceLabel4;
                price = 18.00;
        }


        if (selected.toString().equals("Mała")) {
            price = price * 0.75;
            label.setText(price.toString());
        } else if (selected.toString().equals("Średnia")) {
            label.setText(price.toString());
        } else if (selected.toString().equals("Duża")) {
            price = price * 1.25;
            label.setText(price.toString());
        } else if (selected.toString().equals("Familijna")) {
            price = price * 1.5;
            label.setText(price.toString());
        }


    }
}

