/**
 * Created by igor on 14.11.16.
 */
public class Order {

    String isFinished;
    String number;
    String pizza;
    String price;
    String destination;


    //Konstruktor obiektu, przyjmujący wartości
    public Order(String number, String pizza, String destination, String isFinished, String price) {

        this.number = number;
        this.destination = destination;
        this.pizza = pizza;
        this.isFinished = isFinished;
        this.price = price;

    }


    //Gettery i Settery
    public String getNumber() {

        return this.number;

    }

    public String getPizza() {

        return this.pizza;

    }

    public String getDestination() {

        return this.destination;

    }

    public String getPrice() {

        return this.price;

    }

    public String getIsFinished() {

        return this.isFinished;

    }

    public void setIsFinished(Boolean done) {

        this.isFinished = "Zakończone";

    }

}
