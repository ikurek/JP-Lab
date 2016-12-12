import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class MainFrame extends JFrame {

    //TODO: Po co to jest?
    private static final long serialVersionUID = 1L;
    //Publiczne definicje wątków żeby można było je zatrzymać z metod wewnątrz funkcji
    private static Thread loopAnimationThread;
    private static Thread grabAnimationThread;
    private static CustomPanel customPanel = null;
    private JPanel jContentPane = null;


    //Pusty konstruktor dla okna
    private MainFrame() {
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
                        if (MainFrame.customPanel != null && MainFrame.customPanel.grabberGraphics != null) {
                            MainFrame.customPanel.grabberGraphics.rotateToLeft();
                            MainFrame.customPanel.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {
                            System.out.print(e);
                        }
                    }
                    for (int i = 0; i < 99; i++) {
                        if (MainFrame.customPanel != null && MainFrame.customPanel.grabberGraphics != null) {
                            MainFrame.customPanel.grabberGraphics.rotateToRight();
                            MainFrame.customPanel.repaint();
                        }

                        try {
                            Thread.currentThread().sleep(100);
                        } catch (Exception e) {

                            System.out.print(e);
                        }
                    }
                }

            }
        });


        grabAnimationThread = new Thread(new Runnable() {
            public void run() {


                while (true) {

                    if (MainFrame.customPanel != null && MainFrame.customPanel.grabberGraphics != null) {
                        MainFrame.customPanel.grabberGraphics.grab();
                        MainFrame.customPanel.circleGraphics.MoveCircleStart();
                    }
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }


            }
        });

        //Odpal wątek odpowiedzialny za animację chwytaka
        loopAnimationThread.start();
        grabAnimationThread.start();
        try{
            grabAnimationThread.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                loopAnimationThread.stop();

                if(grabAnimationThread.isAlive()) {
                    grabAnimationThread.notify();
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
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