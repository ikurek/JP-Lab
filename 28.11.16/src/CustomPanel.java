import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 09.12.16.
 */

public class CustomPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    public ForkGraphics forkGraphics;
    public CircleGraphics circleGraphics;


    //Pusty konstruktor
    public CustomPanel() {
        super();
        initialize();
        circleGraphics = new Circle();
        forkGraphics = new Fork();

    }

    //Inicjalizacja panelu CustomPanel
    private void initialize() {
        this.setSize(300, 300);
        this.setLayout(new GridBagLayout());

    }

    //Metoda rysuje elementy na panelu
    //Wywołuj metode drawme chwytatka i kółek
    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (circleGraphics != null) {
            circleGraphics.drawMe(arg0);
        }
        if (forkGraphics != null) {
            forkGraphics.drawToy(arg0);
        }
    }

}
