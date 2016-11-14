import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by igor on 14.11.16.
 */
public class main {

    private static Scanner point;

    public static void main(String[] args)
    {
        System.out.println("Wprowadz liczbe linii: ");
        point = new Scanner(System.in);
        int c_lines = point.nextInt();

        ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
        Point2D.Double po = new Point2D.Double(0,0);

        int goal=0;
        double x;
        double y;

        // przypisanie punktów

        for(int i=0; i<c_lines*2; i++)
        {
            System.out.println("Wprowadz punkt x dla "+i+" punktu: ");
            x=point.nextInt();
            System.out.println("Wprowadz punkt y dla "+i+" punktu: ");
            y=point.nextInt();
            po.setLocation(x, y);
            points.add(po);
        }

        ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();
        Line2D.Double lin = new Line2D.Double();

        // tworzenie odcinków

        double x1;
        double y1;
        double x2;
        double y2;

        for(int i=0; i<c_lines*2; i++)
        {
            for (int j = i +1; j < c_lines*2; j++) {

                x1 = points.get(i).getX();
                y1 = points.get(i).getY();
                x2 = points.get(j).getX();
                y2 = points.get(j).getY();

                lin.setLine(x1, y1, x2, y2);
                lines.add(lin);

            }


        }
        System.out.println("ok!");
        System.out.println(lines.get(0));
        System.out.println(lines.get(1));

        //sprawdzanie czy się przecinają
        for(int i=0; i<c_lines; i++)
        {
            for(int j=i+1; j<c_lines; j++)
            {
                if(j!=c_lines)
                {
                    Line2D.Double line1=lines.get(i);
                    Line2D.Double line2=lines.get(j);

                    System.out.println("Ok!"+i+" "+j);
                    if((line1.intersectsLine(line2))==true)
                    {
                        goal++;
                        System.out.println("Ok!");
                    }
                }
            }
        }
        System.out.println(goal);
    }

}
