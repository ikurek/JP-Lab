import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by igor on 03.01.17.
 */

//Zawiera okno z tabelą jako GUI
public class MainWindow extends JFrame{
    private JSpinner spinnerSpeed;
    private JTable table1;
    private JButton buttonStart;
    private JPanel mainJPanel;
    DefaultTableModel tableModel = new DefaultTableModel(15, 30);

    public MainWindow() {
        super("Rare Pepe");
        setContentPane(mainJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        table1.setModel(tableModel);
        DrawTableEngine();
        pack();
        setVisible(true);
    }

    public void DrawTableEngine() {

        table1.setValueAt("x", 7, 2);
        table1.setValueAt("x", 8, 2);

        table1.setValueAt("-", 7, 3);
        table1.setValueAt("-", 8, 3);
    }

}
