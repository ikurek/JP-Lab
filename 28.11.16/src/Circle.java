import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 09.12.16.
 */

public class Circle extends CircleGraphics {

    //Zmienne przehowujące kąt obrotu chwytaka
    //Oraz listę wszystkich kółek do narysowania
    public static double alpha = 0;
    List<CircleObject> wheel = new ArrayList<>();

    //Zwraca kąt pod jakim aktualnie znajduje się chwytak
    public static double getAlpha() {
        return alpha;
    }

    //Funkcje modyfikujące długość ramienia
    //armDown wydłuza, armUp Skraca
    //TODO: Pewnie da się to zrobić sensowniej.
    public void armDown() {

        wheel.get(0).setY1(wheel.get(0).getY1() - 1);

        for (int i = 1; i < wheel.size(); i++) {
            wheel.get(i).setY1(wheel.get(i).getY1() - 1);
            wheel.get(i).setY2(wheel.get(i).getY2() - 1);

        }
    }

    public void armUp() {

        wheel.get(0).setY1(wheel.get(0).getY1() - 1);

        for (int i = 1; i < wheel.size(); i++) {
            wheel.get(i).setY1(wheel.get(i).getY1() + 1);
            wheel.get(i).setY2(wheel.get(i).getY2() + 1);

        }
    }


    //Funkcje obrotu dla chwytaka
    //Jedna z minusem na kacie, druga z plusem
    public void rotateToLeft() {

        if (alpha >= -Math.PI / 2) alpha -= Math.PI / 100;

    }

    public void rotateToRight() {

        if (alpha <= Math.PI / 2) alpha += Math.PI / 100;

    }

    public void grab() {
        armUp();
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //Zmienne dla transformaty affinicznej
        //Rzmiar ekranu, środek, margines dla poczatku chwytaka
        int dx0 = g2d.getDeviceConfiguration().getBounds().width / 2;
        int dy0 = -20;
        int minxy = (dx0 >= -dy0) ? -dy0 : dx0;

        //Machnijmy transformację affiniczną
        //1 na 1, 1 na -1
        //obrót o podany kąt
        AffineTransform saveAT = g2d.getTransform();
        customAffineTransform = new AffineTransform();
        customAffineTransform.scale(1, -1);
        customAffineTransform.translate(dx0, dy0);
        customAffineTransform.rotate(alpha);
        g2d.setTransform(customAffineTransform);


        //Dodanie kóleczek do listy
        CircleObject w = new CircleObject(0, -(minxy * 3) - 10, 0, -minxy);
        wheel.add(w);

        CircleObject w1 = new CircleObject(-10, (-minxy * 3) - 10, -10, -minxy * 3);
        wheel.add(w1);

        CircleObject w2 = new CircleObject(10, (-minxy * 3) - 10, 10, -minxy * 3);
        wheel.add(w2);

        CircleObject w3 = new CircleObject(10, -minxy * 3, -10, -minxy * 3);
        wheel.add(w3);


        //Rysowanie kółeczek
        for (int i = 0; i < wheel.size(); i++) {
            g2d.drawLine(wheel.get(i).getX1(), wheel.get(i).getY1(), wheel.get(i).getX2(), wheel.get(i).getY2());
        }

        g2d.drawOval(-minxy, -minxy, minxy * 2, minxy * 2);


        //Zmiana poprzedniej transformacji na tą zapisaną w zmiennej saveAT
        //TODO: Było w kodzie, ale po co to właściwie jest?
        g2d.setTransform(saveAT);

    }

}