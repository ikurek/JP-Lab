import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by igor on 03.01.17.
 */

//Zawiera okno z tabelą jako GUI
class MainWindow extends JFrame {

    //Deklaracje zmiennych
    public static TapeStorage tapeStorage = new TapeStorage();
    public static Integer sleep = 3000;
    //Wartości
    private static Integer spaces = 1;
    private final DefaultTableModel tableModel = new DefaultTableModel(15, 30);
    //Wątki
    private final Thread addThread = new AddThread();
    private final Thread pushThread = new PushThread();
    private Integer canAddNew = 0;
    private Integer canPull1 = 1;
    private Integer canPull2 = 1;
    private Thread pullThread;
    private JSpinner spinnerSpaces;
    private JTable tableUI;
    private JButton buttonStart;
    private JPanel mainJPanel;
    private JSpinner spinnerSleep;


    public MainWindow() {
        super("Transmisja 2.1");
        setContentPane(mainJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        spinnerSleep.setValue(1000);
        spinnerSpaces.setValue(1);
        SetupTable();
        DrawTableUI();
        PrintTapeStorage();
        pack();
        setVisible(true);

        //Wątek zawiera pętle odpalającą inne wątki
        Thread startMeUp = new Thread(() -> {
            while (true) {


                try {
                    canPull1++;
                    System.out.println("Current canPull1 value: " + canPull1);
                    canPull2++;
                    System.out.println("Current canPull2 value: " + canPull2);
                    //Zwiększa licznik, jeżeli jest równy dodaje nowy element
                    if (canAddNew == spaces) {
                        addThread.start();
                        addThread.join();
                        canAddNew = 0;
                    } else {
                        canAddNew++;
                    }

                    PrintTapeStorage();

                    //Przesuwa taśmę o 1 w prawo
                    pushThread.start();
                    pushThread.join();

                    PrintTapeStorage();

                    if (canPull1 >= 2 && MainWindow.tapeStorage.getValueInField(8) != 0) {


                        //Pierwszy rząd wartości
                        pullThread = new PullThread(0, 8);
                        pullThread.start();
                        pullThread.join();
                        PrintTapeStorage();

                        //Drugi rząd wartości
                        pullThread = new PullThread(1, 8);
                        pullThread.start();
                        pullThread.join();
                        PrintTapeStorage();

                        //Zerowanie licznika
                        canPull1 = 0;
                    }

                    if (canPull2 >= 2 && MainWindow.tapeStorage.getValueInField(10) != 0) {


                        //Pierwszy rząd wartości
                        pullThread = new PullThread(0, 10);
                        pullThread.start();
                        pullThread.join();
                        PrintTapeStorage();

                        //Drugi rząd wartości
                        pullThread = new PullThread(1, 10);
                        pullThread.start();
                        pullThread.join();
                        PrintTapeStorage();

                        //Zerowanie licznika
                        canPull2 = 0;
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        //Listener do guzika
        buttonStart.addActionListener(actionEvent -> {
            spaces = Integer.valueOf(spinnerSpaces.getValue().toString());
            sleep = Integer.valueOf(spinnerSleep.getValue().toString());
            if (startMeUp.isAlive()) {
                startMeUp.interrupt();
            } else {
                startMeUp.start();
            }

        });
    }


    //Konfiguracja tabeli
    private void SetupTable() {
        tableUI.setModel(tableModel);
        tableUI.setCellSelectionEnabled(false);
        tableUI.setRowSelectionAllowed(false);
    }

    //Rysuje "interfejs"...
    private void DrawTableUI() {

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
    private void PrintTapeStorage() {

        Integer[][] valuesInTapeStorage = MainWindow.tapeStorage.getTapeFields();

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
