import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;


public class Grabber extends GrabberGraphics {

    //Zmienne przehowujące kąt obrotu chwytaka
    //Oraz listę prostych z których składa się trójząb
    private static double alpha = Math.PI / 2;
    private final List<GrabberObject> grabberObjectArrayList = new ArrayList<>();

    //Zwraca kąt pod jakim aktualnie znajduje się chwytak
    public static double getAlpha() {
        return alpha;
    }

    //Funkcje modyfikujące długość ramienia
    //armDown wydłuza, armUp Skraca
    //TODO: Pewnie da się to zrobić sensowniej.
    public void armDown() {

        grabberObjectArrayList.get(0).setY1(grabberObjectArrayList.get(0).getY1() - 1);

        for (int i = 1; i < grabberObjectArrayList.size(); i++) {
            grabberObjectArrayList.get(i).setY1(grabberObjectArrayList.get(i).getY1() - 1);
            grabberObjectArrayList.get(i).setY2(grabberObjectArrayList.get(i).getY2() - 1);

        }
    }

    void armUp() {

        grabberObjectArrayList.get(0).setY1(grabberObjectArrayList.get(0).getY1() - 1);

        for (int i = 1; i < grabberObjectArrayList.size(); i++) {
            grabberObjectArrayList.get(i).setY1(grabberObjectArrayList.get(i).getY1() + 1);
            grabberObjectArrayList.get(i).setY2(grabberObjectArrayList.get(i).getY2() + 1);

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
        grabberAffineTransform = new AffineTransform();
        grabberAffineTransform.scale(1, -1);
        grabberAffineTransform.translate(dx0, dy0);
        grabberAffineTransform.rotate(alpha);
        g2d.setTransform(grabberAffineTransform);


        //Dodanie kóleczek do listy
        GrabberObject forkPart0 = new GrabberObject(0, -(minxy * 3) - 10, 0, -minxy);
        grabberObjectArrayList.add(forkPart0);

        GrabberObject forkPart1 = new GrabberObject(-10, (-minxy * 3) - 10, -10, -minxy * 3);
        grabberObjectArrayList.add(forkPart1);

        GrabberObject forkPart2 = new GrabberObject(10, (-minxy * 3) - 10, 10, -minxy * 3);
        grabberObjectArrayList.add(forkPart2);

        GrabberObject forkPart3 = new GrabberObject(10, -minxy * 3, -10, -minxy * 3);
        grabberObjectArrayList.add(forkPart3);


        //Rysowanie poszczególnych elementów chwytaka
        for (GrabberObject grabberObject : grabberObjectArrayList) {
            g2d.drawLine(grabberObject.getX1(), grabberObject.getY1(), grabberObject.getX2(), grabberObject.getY2());
        }

        //Rysowanie półkola na górze chwytaka
        g2d.drawOval(-minxy, -minxy, minxy * 2, minxy * 2);


        //Zmiana poprzedniej transformacji na tą zapisaną w zmiennej saveAT
        //TODO: Było w kodzie, ale po co to właściwie jest?
        g2d.setTransform(saveAT);

    }

}