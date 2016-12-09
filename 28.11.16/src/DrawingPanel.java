import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 09.12.16.
 */
public class DrawingPanel extends JPanel {

    Integer test;

    public DrawingPanel() {
        setSize(1280, 720);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(0,0,1280, 720);
    }

    public void rotate(Graphics2D g) {
        g.rotate(2);
    }
}
