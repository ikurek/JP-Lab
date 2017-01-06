/**
 * Created by igor on 03.01.17.
 */
public class TapeStorage {

    //Powinna być tablica ale tak jest łatwiej z dostępem
    private Integer[][] tapeFields = new Integer[2][12];

    public TapeStorage() {

        //Zeruje tablicę w momencie inicjalizacji klasy
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                this.tapeFields[i][j] = 0;
            }
        }
    }

    //Zwraca tablicę dwuwymiarową z danymi na taśmie
    public Integer[][] getTapeFields() {

        return this.tapeFields;

    }

    //Ustawia nową tablicę dwuwymiarową
    public void setTapeFields(Integer[][] tapeFields) {

        this.tapeFields = tapeFields;

    }

    //Zwraca wartośc w danym polu
    public Integer getValueInField(int column) {

        return this.tapeFields[0][column];

    }

    //Ustawia wartość w danym polu
    public void setValueInField(int row, int value) {

        this.tapeFields[row][0] = value;

    }
}
