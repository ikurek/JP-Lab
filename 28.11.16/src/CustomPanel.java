import javax.swing.*;
import java.awt.*;


class CustomPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    public final CircleGraphics circleGraphics;
    public final GrabberGraphics grabberGraphics;


    //konstruktor panelu
    //Tworzy nowe obiekty klasy circle i fork
    public CustomPanel() {
        super();
        initialize();
        grabberGraphics = new Grabber();
        circleGraphics = new Circle();

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
        if (grabberGraphics != null) {
            grabberGraphics.drawMe(arg0);
        }
        if (circleGraphics != null) {
            circleGraphics.drawCircle(arg0);
        }
    }

}
