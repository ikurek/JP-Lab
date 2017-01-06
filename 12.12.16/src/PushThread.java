/**
 * Created by igor on 06.01.17.
 */
public class PushThread extends Thread {

    public EngineControl engineControl = new EngineControl();

    public void run() {
        MainWindow.tapeStorage = engineControl.PushTapeElementsForward(MainWindow.tapeStorage);
        System.out.println("pushThread Started");

    }

    public void start() {
        run();

        try {
            Thread.sleep(MainWindow.sleep);
        } catch (InterruptedException e){
            System.out.print("pushThread sleep failed: " + e.toString() + "\n");
        }

        System.out.println("pushThread Finished");

    }

}
