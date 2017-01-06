import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by igor on 03.01.17.
 */

//Zawiera okno z tabelą jako GUI
public class MainWindow extends JFrame {

    //Deklaracje zmiennych
    public static TapeStorage tapeStorage = new TapeStorage();
    public static EngineControl engineControl = new EngineControl();
    DefaultTableModel tableModel = new DefaultTableModel(15, 30);
    private JSpinner spinnerSpaces;
    private JTable tableUI;
    private JButton buttonStart;
    private JPanel mainJPanel;
    private JSpinner spinnerSleep;

    //Wątki
    Thread addThread = new AddThread();
    Thread pushThread = new PushThread();


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



        Thread updateUIThread = new Thread(new Runnable() {
            @Override
            public void run() {
                PrintTapeStorage();
            }
        });

        while (true) {



            try {
                addThread.start();
                addThread.join();

                PrintTapeStorage();

                pushThread.start();
                pushThread.join();
                PrintTapeStorage();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

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
    //Zastępuje 0 pustym miejscem
    public void PrintTapeStorage() {

        Integer[][] valuesInTapeStorage = this.tapeStorage.getTapeFields();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                if (valuesInTapeStorage[i][j] != 0 && valuesInTapeStorage[i][j] != null) {
                    tableUI.setValueAt(valuesInTapeStorage[i][j], 7 + i, 5 + j);
                } else {
                    tableUI.setValueAt(null, 7 + i, 5 + j);
                }
            }
        }

    }

}
