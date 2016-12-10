import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;


//Kopia klasy GObject z oryginalnego kodu
//Zbudowana na potrzeby obsługi kółek

abstract public class CircleGraphics {

    AffineTransform circleAffineTransform;

    abstract public void drawCircle(Graphics a);

    abstract public void MoveCircle(List<CircleObject> circle);

    abstract public void MoveCircleStart();

    abstract void rotate();


}