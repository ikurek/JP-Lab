//Klasa uruchamia pozostałe okna, cały program, itd.
public class Test {
    public static void main(String[] args) {
        new Server();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
        new Monitor();
        new User("Bramka 1");
        new User("Bramka 2");
    }
}
