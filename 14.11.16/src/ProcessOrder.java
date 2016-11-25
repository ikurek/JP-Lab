import java.util.ArrayList;

/**
 * Created by igor on 14.11.16.
 */

//Klasa służy do przetwarzania zamówień
//Usuwanie, dodawanie, itd
public class ProcessOrder {

    //Funkcja dodaje tworzy obiekt klasy order
    public Order createOrder(String number, String adress, String pizza, String price, String driver, String isFinished) {

        Order order = new Order(number, adress, pizza, price, driver, isFinished);

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



        String[] result = {order.getNumber(), order.getAdress(), order.getPizza(), order.getPrice(), "Andrzej", order.getIsFinished()};


        return result;
    }

}
