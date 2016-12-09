import javax.swing.*;
import java.awt.*;

/**
 * Created by igor on 09.12.16.
 */

public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    public GToy a;
    public GObject g;  //  @jve:decl-index=0:

    /**
     * This is the default constructor
     */
    public MyPanel() {
        super();
        initialize();
        g = new Wheel();
        a = new Toy();

    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(300, 300);
        this.setLayout(new GridBagLayout());

    }

//Metoda rysuje elementy na panelu
    //Wywołuj metode drawme chwytatka i kółek
    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (g != null) {
            g.drawMe(arg0);
        }
        if (a != null) {
            a.drawToy(arg0);
        }
    }

}
