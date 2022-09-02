import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean inGame = true;
        while (inGame) {
            System.out.println("1. Create New Character || 2. Returning Character || 3. Edit Game Files || 4. Exit Game");
            String menuchoice = in.nextLine();
            if (menuchoice.equals("1")) {
                //Create Character
            } else if (menuchoice.equals("2")) {
                //Return to existing character
            } else if (menuchoice.equals("3")) {
                //Edit Game Files
            } else if (menuchoice.equals("4")) {
                //Exit Game
                inGame = false;
            }
        }
    }
}
