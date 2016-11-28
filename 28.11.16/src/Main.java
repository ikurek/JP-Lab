import java.awt.*;

/**
 * Created by igor on 28.11.16.
 */
public class Main {

    public static void main(String[] args) {

        //Odpala główne okno
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });

    }
}
