import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 09.12.16.
 */


public class Fork extends ForkGraphics {

    public double alpha = Math.PI / 2;
    List<ForkObject> toy = new ArrayList<ForkObject>();

    public void rotate() {
        alpha = Circle.getAlpha();
    }

    public void MoveToy(List<ForkObject> toy) {
        toy.get(1).setX(toy.get(1).getX() + 1);
    }

    public void drawToy(Graphics a) {

        Graphics2D g2d = (Graphics2D) a;


        int dx0 = g2d.getDeviceConfiguration().getBounds().width / 2;
        int dy0 = -20;
        int minxy = (dx0 >= -dy0) ? -dy0 : dx0;
        AffineTransform saveAT = g2d.getTransform();

        t1 = new AffineTransform();
        t1.scale(1, -1);
        t1.translate(dx0, dy0);
        t1.rotate(alpha);
        g2d.setTransform(t1);


        ForkObject o = new ForkObject(-minxy - 300, -minxy + 300, minxy * 2, minxy * 2);
        toy.add(o);

        ForkObject o1 = new ForkObject(-minxy - 300, -minxy + 200, minxy * 2, minxy * 2);
        toy.add(o1);

        ForkObject o2 = new ForkObject(-minxy - 300, -minxy + 100, minxy * 2, minxy * 2);
        toy.add(o2);

        ForkObject o3 = new ForkObject(-minxy - 300, -minxy, minxy * 2, minxy * 2);
        toy.add(o3);

        ForkObject o4 = new ForkObject(-minxy - 300, -minxy - 100, minxy * 2, minxy * 2);
        toy.add(o4);

        ForkObject o5 = new ForkObject(-minxy - 300, -minxy - 200, minxy * 2, minxy * 2);
        toy.add(o5);

        ForkObject o6 = new ForkObject(-minxy - 300, -minxy - 300, minxy * 2, minxy * 2);
        toy.add(o6);

        for (int i = 0; i < toy.size(); i++) {
            g2d.drawOval(toy.get(i).getX(), toy.get(i).getY(), toy.get(i).getWidth(), toy.get(i).getHeight());

        }

        g2d.setTransform(saveAT);

    }

    public void MoveToyStart() {
        MoveToy(toy);

    }
}