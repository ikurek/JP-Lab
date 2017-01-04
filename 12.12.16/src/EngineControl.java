import java.util.Random;

/**
 * Created by igor on 04.01.17.
 */
public class EngineControl {


    //Pusty konstruktorek
    public EngineControl() {

    }

    //Funkcja dodaje nowe elementy do taśmy
    //Losowe liczby na pierwszej pozycji taśmy
    public TapeStorage AddNewElementToTapeStorage(TapeStorage tapeStorage) {

        Random random = new Random();

        tapeStorage.setValueInField(0, 0, random.nextInt(9) + 1);
        tapeStorage.setValueInField(1, 0, random.nextInt(9) + 1);

        return tapeStorage;
    }

    public TapeStorage PushTapeElementsForward(TapeStorage tapeStorage) {

        //Zczytaj stary aray i stwórz nowy
        Integer[][] oldTapeStorageElements = tapeStorage.getTapeFields();
        Integer[][] newTapeStorageElements = new Integer[2][12];

        //Na pierwsze elementy nowego arrayu przypisz 0
        newTapeStorageElements[0][0] = 0;
        newTapeStorageElements[1][0] = 0;

        //WOW. Działa.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 11; j++) {
                if (oldTapeStorageElements[i][j] != 0) {
                    newTapeStorageElements[i][j + 1] = oldTapeStorageElements[i][j];
                } else {
                    newTapeStorageElements[i][j + 1] = 0;
                }
            }
        }

        tapeStorage.setTapeFields(newTapeStorageElements);

        return tapeStorage;
    }
}
