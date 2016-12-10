import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

//Klasa zawiera transofrmatę affiniczną dla kółek
//Rysuje kółka w dolnej części panelu

public class Circle extends CircleGraphics {

    private final List<CircleObject> circleObjectArrayList = new ArrayList<>();
    private double alpha = Math.PI / 2;

    public void rotate() {
        alpha = Grabber.getAlpha();
    }

    public void MoveCircle(List<CircleObject> circle) {
        circle.get(1).setX(circle.get(1).getX() + 1);
    }

    public void drawCircle(Graphics a) {

        Graphics2D g2d = (Graphics2D) a;


        int dx0 = g2d.getDeviceConfiguration().getBounds().width / 2;
        int dy0 = -20;
        int minxy = (dx0 >= -dy0) ? -dy0 : dx0;
        AffineTransform saveAT = g2d.getTransform();

        circleAffineTransform = new AffineTransform();
        circleAffineTransform.scale(1, -1);
        circleAffineTransform.translate(dx0, dy0);
        circleAffineTransform.rotate(alpha);
        g2d.setTransform(circleAffineTransform);


        //Dodaje obiekty kół do listy
        //Środek wyznacza punkt -minxy
        CircleObject bottomCircle0 = new CircleObject(-minxy - 300, -minxy + 200, minxy * 2, minxy * 2);
        circleObjectArrayList.add(bottomCircle0);

        CircleObject bottomCircle1 = new CircleObject(-minxy - 300, -minxy + 100, minxy * 2, minxy * 2);
        circleObjectArrayList.add(bottomCircle1);

        CircleObject bottomCircle2 = new CircleObject(-minxy - 300, -minxy, minxy * 2, minxy * 2);
        circleObjectArrayList.add(bottomCircle2);

        CircleObject bottomCircle3 = new CircleObject(-minxy - 300, -minxy - 100, minxy * 2, minxy * 2);
        circleObjectArrayList.add(bottomCircle3);

        CircleObject bottomCircle4 = new CircleObject(-minxy - 300, -minxy - 200, minxy * 2, minxy * 2);
        circleObjectArrayList.add(bottomCircle4);


        //Rysuje koło dal każdego obiektu na liście
        for (CircleObject circleObject : circleObjectArrayList) {
            g2d.drawOval(circleObject.getX(), circleObject.getY(), circleObject.getWidth(), circleObject.getHeight());

        }

        //Zmiana poprzedniej transformacji na tą zapisaną w zmiennej saveAT
        //TODO: Było w kodzie, ale po co to właściwie jest?
        g2d.setTransform(saveAT);

    }

    //Porusza koło w górę
    public void MoveCircleStart() {
        MoveCircle(circleObjectArrayList);

    }
}