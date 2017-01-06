/**
 * Created by igor on 06.01.17.
 */
class PullThread extends Thread {

    private final EngineControl engineControl = new EngineControl();
    private final Integer row;
    private final Integer column;

    public PullThread(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void run() {
        System.out.println("pullThread Started for: " + row + " - " + column);
        MainWindow.tapeStorage = engineControl.RemoveElementFromTapeStorage(MainWindow.tapeStorage, row, column);

    }

    public void start() {
        run();

        try {
            Thread.sleep(MainWindow.sleep);
        } catch (InterruptedException e) {
            System.out.print("pullThread sleep failed: " + e.toString() + "\n");
        }

        System.out.println("pullThread Finished");
    }

}
