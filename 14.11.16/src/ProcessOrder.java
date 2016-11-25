import java.util.ArrayList;

/**
 * Created by igor on 14.11.16.
 */

//Klasa służy do przetwarzania zamówień
//Usuwanie, dodawanie, itd
public class ProcessOrder {

    //Funkcja dodaje tworzy obiekt klasy order
    public Order createOrder(String number, String pizza, String destination, String isFinished, String price) {

        Order order = new Order(number, pizza, destination, isFinished, price);

        return order;
    }

    //Funkcja przyjmuje listę i obiekt klasy order
    //Zwraca listę z dodanym obiektem order
    public ArrayList<Order> addOrder(ArrayList<Order> listOfOrders, Order order) {

        listOfOrders.add(order);
        return listOfOrders;

    }

    //Funkcja zamienia obiekt order na tablicę stringów
    //Konieczne żeby móc wyświetlić order w tablicy
    public String[] parseOrderToStringArray(Order order) {



        String[] result = {order.getNumber(), "0", order.getPrice(), order.getDestination(), "Andrzej", order.isFinished};


        return result;
    }

}
