import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 28.11.16.
 */

public class MainFrame extends JFrame {

    //TODO: Po co to jest?
    private static final long serialVersionUID = 1L;
    //Publiczne definicje wątków żeby można było je zatrzymać z metod wewnątrz funkcji
    public static Thread loopAnimationThread;
    public static Thread grabAnimationThread;
    static CustomPanel customPanel = null;
    private JPanel jContentPane = null;


    //Pusty konstruktor dla okna
    public MainFrame() {
        super();
        initialize();
        setLocationRelativeTo(null);

    }


    //Podstawowa konfiguracj okna
    //Wątki dla trwałych animacji

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame thisClass = new MainFrame();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setLocationRelativeTo(null);
                thisClass.setSize(1920, 900);
                thisClass.setVisible(true);
            }
        });

        loopAnimationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    for (int i = 0; i < 99; i++) {
                        if (MainFrame.customPanel != null && MainFrame.customPanel.circleGraphics != null) {
                            MainFrame.customPanel.circleGraphics.rotateToLeft();
                            MainFrame.customPanel.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {
                        }
                    }
                    for (int i = 0; i < 99; i++) {
                        if (MainFrame.customPanel != null && MainFrame.customPanel.circleGraphics != null) {
                            MainFrame.customPanel.circleGraphics.rotateToRight();
                            MainFrame.customPanel.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {
                        }
                    }
                }

            }
        });


        grabAnimationThread = new Thread(new Runnable() {
            public void run() {


                while (true) {

                    if (MainFrame.customPanel != null && MainFrame.customPanel.circleGraphics != null) {
                        MainFrame.customPanel.circleGraphics.grab();
                        MainFrame.customPanel.forkGraphics.MoveToyStart();
                    }
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (Exception e) {
                    }

                }


            }
        });

        //Odpal oba wątki odpowiedzialne za animację elementów
        loopAnimationThread.start();
        //     grabAnimationThread.start();

    }

    //inicjalizacja panelu customPanel
    //Zwraca obiekt typu CustomPanel
    private CustomPanel getMp() {
        if (customPanel == null) {
            customPanel = new CustomPanel();
            customPanel.setLayout(new GridBagLayout());
        }
        return customPanel;
    }

    //konfiguracja Głównego okna
    private void initialize() {
        this.setSize(1920, 900);
        this.setContentPane(getJContentPane());
        this.setTitle("Gra 1.1");
        this.setLocationRelativeTo(null);
    }

    //Konfiguracja JPanel
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getMp(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

}