import java.awt.*;
import java.util.ArrayList;

public class Main {

    public ArrayList<Order> listOfOrders = new ArrayList<>();

    public static void main(String[] args) {

        //Pokaż okno dialogowe
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });

    }
}