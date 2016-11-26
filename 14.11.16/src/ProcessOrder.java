import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by igor on 14.11.16.
 */

//Klasa służy do przetwarzania zamówień
//Usuwanie, dodawanie, itd
public class ProcessOrder {

    //Funkcja przyjmuje listę i obiekt klasy order
    //Zwraca listę z dodanym obiektem order
    public ArrayList<Order> addOrder(ArrayList<Order> listOfOrders, Order order) {

        listOfOrders.add(order);
        return listOfOrders;

    }

    //Funkcja zamienia obiekt order na tablicę stringów
    //Konieczne żeby móc wyświetlić order w tablicy
    public String[] parseOrderToStringArray(Order order) {

        String[] result = {order.getNumber(), order.getAdress(), order.getPizza(), order.getPrice(), "Nie przyznano", order.getIsFinished()};


        return result;
    }

    //Funkcja przyjmuje obiekt typu order
    //Zwraca obiekt typu order z dopasowanym kierowcą
    public String assignDriver(Order order) {

        String driver = "Nie przyznano";
        order.getAdress();

        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt(4-1) + 1;

        switch(randomNum) {
            case(1):
                driver = "Andrzej";
                break;

            case(2):
                driver = "Krzysztof";
                break;

            case(3):
                driver = "Stefan";
                break;

            case(4):
                driver = "Jarek";
                break;
        }


        return driver;
    }

    public String assignDate() {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public String generateLog(ArrayList<Order> listOfOrders) {

        StringBuilder log = new StringBuilder();

        log.append("Godzina - ");
        log.append("Numer - ");
        log.append("Adres - ");
        log.append("Status - ");
        log.append(System.lineSeparator());


        for(Order order : listOfOrders) {

            log.append(order.getDateOfOrder() + " - ");
            log.append(order.getNumber() + " - ");
            log.append(order.getAdress() + " - ");
            log.append(order.getIsFinished());
            log.append(System.lineSeparator());

        }

        return log.toString();

    }

}
