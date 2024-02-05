import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);

    public String getUserInput() {
        return input.nextLine();
    }

    public void speak(String message) {
        System.out.println(message);
    }


}
