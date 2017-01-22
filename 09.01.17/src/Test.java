//Klasa uruchamia pozostałe okna, cały program, itd.
public class Test {
    public static void main(String[] args) {
        System.out.println("Uruchomiono funkcję testu...");
        new Server();
        System.out.println("Serwer: OK");

        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
        new Monitor();
        System.out.println("Monitor: OK");
        new User("Bramka 1");
        System.out.println("Bramka 1: OK");
        new User("Bramka 2");
        System.out.println("Bramka 2: OK");
        new User("Bramka 3");
        System.out.println("Bramka 3: OK");

        System.out.println("Funkcja testu zakończona!");
    }
}
