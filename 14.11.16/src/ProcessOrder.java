import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by igor on 14.11.16.
 */

//Klasa służy do przetwarzania zamówień
//Usuwanie, dodawanie, itd
public class ProcessOrder {

    //Funkcja dodaje tworzy obiekt klasy order
    public Order createOrder(Integer number, ArrayList<String> pizza, String destination, Boolean isFinished, Double price) {

        Order order = new Order(number, pizza, destination, isFinished, price);

        return order;
    }

    //Funkcja przyjmuje listę i obiekt klasy order
    //Zwraca listę z dodanym obiektem order
    public ArrayList<Order> addOrder(ArrayList<Order> listOfOrders, Order order) {

        listOfOrders.add(order);
        return listOfOrders;

    }

}
