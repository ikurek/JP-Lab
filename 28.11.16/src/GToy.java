import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

/**
 * Created by igor on 09.12.16.
 */

//Kopia klasy GObject z oryginalnego kodu

abstract public class GToy {
    public AffineTransform t1;

    abstract public void drawToy(Graphics a);

    abstract public void MoveToy(List<ToyData> toy);

    abstract public void MoveToyStart();

    abstract void rotate();


}