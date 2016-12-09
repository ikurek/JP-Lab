import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 28.11.16.
 */

public class MainFrame extends JFrame {

    //TODO: Po co to jest?
    private static final long serialVersionUID = 1L;
    static MyPanel mp = null;
    private JPanel jContentPane = null;


    //Pusty konstruktor dla okna
    public MainFrame() {
        super();
        initialize();

    }


    //Podstawowa konfiguracj okna
    //Wątki dla trwałych animacji

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame thisClass = new MainFrame();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });

        Thread loopAnimationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    for (int i = 0; i < 100; i++) {
                        if (MainFrame.mp != null && MainFrame.mp.g != null) {
                            MainFrame.mp.g.rotateToLeft();
                            MainFrame.mp.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {
                        }
                    }
                    for (int i = 0; i < 99; i++) {
                        if (MainFrame.mp != null && MainFrame.mp.g != null) {
                            MainFrame.mp.g.rotateToRight();
                            MainFrame.mp.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {
                        }
                    }
                }

            }
        });
        loopAnimationThread.start();


        Thread grabAnimationThread = new Thread(new Runnable() {
            public void run() {


                while (true) {

                    if (MainFrame.mp != null && MainFrame.mp.g != null) {
                        MainFrame.mp.g.grab();
                        MainFrame.mp.a.MoveToyStart();
                    }
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (Exception e) {
                    }

                }


            }
        });
        grabAnimationThread.start();

    }

    //inicjalizacja panelu mp
    //Zwraca obiekt typu CustomPanel
    private MyPanel getMp() {
        if (mp == null) {
            mp = new MyPanel();
            mp.setLayout(new GridBagLayout());
        }
        return mp;
    }

    //konfiguracja Głównego okna
    private void initialize() {
        this.setSize(668, 402);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
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