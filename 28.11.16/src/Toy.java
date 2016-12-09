import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 09.12.16.
 */


public class Toy extends GToy {

    public double alpha = Math.PI / 2;
    List<ToyData> toy = new ArrayList<ToyData>();

    public void rotate() {
        alpha = Wheel.getAlpha();
    }

    public void MoveToy(List<ToyData> toy) {
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


        ToyData o = new ToyData(-minxy - 300, -minxy + 300, minxy * 2, minxy * 2);
        toy.add(o);

        ToyData o1 = new ToyData(-minxy - 300, -minxy + 200, minxy * 2, minxy * 2);
        toy.add(o1);

        ToyData o2 = new ToyData(-minxy - 300, -minxy + 100, minxy * 2, minxy * 2);
        toy.add(o2);

        ToyData o3 = new ToyData(-minxy - 300, -minxy, minxy * 2, minxy * 2);
        toy.add(o3);

        ToyData o4 = new ToyData(-minxy - 300, -minxy - 100, minxy * 2, minxy * 2);
        toy.add(o4);

        ToyData o5 = new ToyData(-minxy - 300, -minxy - 200, minxy * 2, minxy * 2);
        toy.add(o5);

        ToyData o6 = new ToyData(-minxy - 300, -minxy - 300, minxy * 2, minxy * 2);
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