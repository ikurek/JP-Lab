import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 09.12.16.
 */
public class DrawingPanel extends JPanel {

    public DrawingPanel() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawArc(0,0,10,10,30,30);
    }

    public void rotate(Graphics2D g) {
        g.rotate(2);
    }
}
