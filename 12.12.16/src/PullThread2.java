/**
 * Created by igor on 06.01.17.
 */
public class PullThread2 {

    public EngineControl engineControl = new EngineControl();

    public void run() {
        System.out.println("pullThread2 Started");

    }

    public void start() {
        run();

        try {
            Thread.sleep(MainWindow.sleep);
        } catch (InterruptedException e){
            System.out.print("pullThread2 sleep failed: " + e.toString() + "\n");
        }

        System.out.println("pullThread2 Finished");
    }
}
