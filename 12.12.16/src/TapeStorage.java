/**
 * Created by igor on 03.01.17.
 */
public class TapeStorage {

    //Powinna być tablica ale tak jest łatwiej z dostępem
    Integer[][] tapeFields = new Integer[2][12];

    public TapeStorage() {

        //Zeruje tablicę w momencie inicjalizacji klasy
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                this.tapeFields[i][j] = 0;
            }
        }
    }

    //Sprawdza czy wartość w danym polu taśmy jest równa 0
    public boolean isFieldEmpty(int row, int column) {

        return this.tapeFields[row][column] == 0;

    }

    //Zwraca tablicę dwuwymiarową z danymi na taśmie
    public Integer[][] getTapeFields() {

        return this.tapeFields;

    }

    //Zwraca wartośc w danym polu
    public Integer getValueInField(int row, int column) {

        return this.tapeFields[row][column];

    }

    //Ustawia wartość w danym polu
    public void setValueInField(int row, int column, int value) {

        this.tapeFields[row][column] = value;

    }
}
