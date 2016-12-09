import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 28.11.16.
 */
public class MainWindow extends JFrame {
    private JPanel drawingWindowJPanel;

    public MainWindow(){
        super("Gra 0.1");
        drawingWindowJPanel = new DrawingPanel();
        setContentPane(drawingWindowJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
