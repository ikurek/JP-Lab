/**
 * Created by igor on 06.01.17.
 */
public class AddThread extends Thread {

    public EngineControl engineControl = new EngineControl();

    public void run() {
        MainWindow.tapeStorage = engineControl.AddNewElementToTapeStorage(MainWindow.tapeStorage);
        System.out.println("addThread Started");
    }


    public void start() {
        run();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.print("addThread sleep failed: " + e.toString());
        }

        System.out.println("addThread Finished");
    }
}
