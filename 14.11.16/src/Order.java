/**
 * Created by igor on 14.11.16.
 */
public class Order {

    String isFinished;
    String number;
    String pizza;
    String price;
    String adress;
    String driver;


    //Konstruktor obiektu, przyjmujący wartości
    public Order(String number, String adress, String pizza, String price, String driver, String isFinished) {

        this.number = number;
        this.adress = adress;
        this.pizza = pizza;
        this.isFinished = isFinished;
        this.price = price;
        this.driver = driver;

    }


    //Gettery i Settery
    public String getNumber() {

        return this.number;

    }

    public String getPizza() {

        return this.pizza;

    }

    public String getAdress() {

        return this.adress;

    }

    public String getPrice() {

        return this.price;

    }

    public String getIsFinished() {

        return this.isFinished;

    }

    public String getDriver() {

        return this.driver;

    }

    public void setDriver(String driver) {

        this.driver = driver;

    }

    public void setIsFinished() {

        this.isFinished = "Zakończone";

    }

}
