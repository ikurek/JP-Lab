import static java.lang.Thread.sleep;

/**
 * Created by igor on 29.01.17.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("Startuje Test...");
        System.out.println("Test uruchamia serwer...");
        ServerMain serverMain = new ServerMain();
        System.out.println("Starting sleep...");
        try{
            sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Test uruchamia bramkę...");
        BramkaMain bramkaMain = new BramkaMain();
    }

}
