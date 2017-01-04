import java.util.Random;

/**
 * Created by igor on 04.01.17.
 */
public class EngineControl {


    //Pusty konstruktorek
    public EngineControl() {

    }

    public TapeStorage PushNewElementToTapeStorage(TapeStorage tapeStorage) {

        Random random = new Random();

        tapeStorage.setValueInField(0, 0, random.nextInt(9) + 1);
        tapeStorage.setValueInField(1, 0, random.nextInt(9) + 1);

        return tapeStorage;
    }

    public TapeStorage PushTapeElementsForward(TapeStorage tapeStorage) {

        return tapeStorage;
    }
}
