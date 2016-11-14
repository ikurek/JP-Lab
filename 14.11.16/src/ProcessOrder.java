import java.util.ArrayList;

/**
 * Created by igor on 14.11.16.
 */
//Klasa służy do przetwarzania zamówień
//Usuwanie, dodawanie, itd
public class ProcessOrder {

    public Order createOrder(Integer number, ArrayList<String> pizza, String destination, Boolean isFinished, Double price) {

        Order order = new Order(number, pizza, destination, isFinished, price);

        return order;
    }

}
