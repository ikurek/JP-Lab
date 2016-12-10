import java.awt.*;
import java.awt.geom.AffineTransform;


//Klasa byla oryginalnie w kodzie z zajęć
//Ja trochę ją zmodyfikowałem
abstract public class GrabberGraphics {
    AffineTransform grabberAffineTransform;

    abstract public void drawMe(Graphics g);

    abstract void rotateToLeft();

    abstract void rotateToRight();

    abstract void armDown();

    abstract void armUp();

    abstract void grab();

}
