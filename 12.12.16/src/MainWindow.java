import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by igor on 03.01.17.
 */

//Zawiera okno z tabelą jako GUI
public class MainWindow extends JFrame {
    DefaultTableModel tableModel = new DefaultTableModel(15, 30);
    TapeStorage tapeStorage = new TapeStorage();
    EngineControl engineControl = new EngineControl();
    private JSpinner spinnerSpeed;
    private JTable tableUI;
    private JButton buttonStart;
    private JPanel mainJPanel;

    public MainWindow() {
        super("Rare Pepe");
        setContentPane(mainJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        SetupTable();
        DrawTableUI();
        PrintTapeStorage();
        pack();
        setVisible(true);

        //TODO: TEMP DO TESTÓW!!!
        this.tapeStorage = engineControl.AddNewElementToTapeStorage(tapeStorage);
        PrintTapeStorage();
        this.tapeStorage = engineControl.PushTapeElementsForward(tapeStorage);
        PrintTapeStorage();

    }

    //Konfiguracja tabeli
    public void SetupTable() {
        tableUI.setModel(tableModel);
        tableUI.setCellSelectionEnabled(false);
        tableUI.setRowSelectionAllowed(false);
    }

    //Rysuje "interfejs"...
    public void DrawTableUI() {

        tableUI.setValueAt("y", 5, 5);
        tableUI.setValueAt("|", 6, 5);
        tableUI.setValueAt("y", 10, 5);
        tableUI.setValueAt("|", 9, 5);

        tableUI.setValueAt("x", 7, 2);
        tableUI.setValueAt("x", 8, 2);
        tableUI.setValueAt("-", 7, 3);
        tableUI.setValueAt("-", 8, 3);

        tableUI.setValueAt("z", 5, 13);
        tableUI.setValueAt("|", 6, 13);
        tableUI.setValueAt("z", 10, 13);
        tableUI.setValueAt("|", 9, 13);

        tableUI.setValueAt("z", 5, 15);
        tableUI.setValueAt("|", 6, 15);
        tableUI.setValueAt("z", 10, 15);
        tableUI.setValueAt("|", 9, 15);
    }

    //Drukuje na ekran aktualną zawartość taśmy
    //TODO: Powinno nie wyświetlać nic jeżeli pole jest puste, ale nie wiem jak zrobić wyświetlanie pustej kratki (jeszcze)
    public void PrintTapeStorage() {

        Integer[][] valuesInTapeStorage = tapeStorage.getTapeFields();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                tableUI.setValueAt(valuesInTapeStorage[i][j], 7 + i, 5 + j);
            }
        }

    }

}
