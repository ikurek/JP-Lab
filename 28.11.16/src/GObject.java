import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by igor on 09.12.16.
 */

abstract public class GObject {
    public AffineTransform customAffineTransform;

    abstract public void drawMe(Graphics g);

    abstract void rotateToLeft();

    abstract void rotateToRight();

    abstract void armDown();

    abstract void armUp();

    abstract void grab();

}
