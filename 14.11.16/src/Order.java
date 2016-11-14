import java.util.ArrayList;

/**
 * Created by igor on 14.11.16.
 */
public class Order {

    Boolean isFinished;
    Integer number;
    ArrayList<String> pizza;
    Double price;
    String destination;


    //Konstruktor obiektu, przyjmujący wartości
    public Order(Integer number, ArrayList<String> pizza, String destination, Boolean isFinished, Double price) {

        this.number = number;
        this.destination = destination;
        this.pizza = pizza;
        this.isFinished = isFinished;
        this.price = price;

    }


    //Gettery i Settery
    public Integer getNumber() {

        return this.number;

    }

    public ArrayList<String> getPizza() {

        return this.pizza;

    }

    public String getDestination() {

        return this.destination;

    }

    public Double getPrice() {

        return this.price;

    }

    public Boolean getIsFinished() {

        return this.isFinished;

    }

    public void setIsFinished(Boolean done) {

        this.isFinished = done;

    }

}
