import Model.Player;
import Services.MenuServices;
import Services.PlayerServices;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean inGame = true;
        while (inGame) {
            System.out.println("1. Create New Character || 2. Returning Character || 3. Exit Game");
            String menuchoice = in.nextLine();
            PlayerServices ps = new PlayerServices();
            MenuServices ms = new MenuServices();
            Player p;
            if (menuchoice.equals("1")) {
                //Create Character
                p = ps.chooseClass(ps);
                ps.addPlayer(p);
            } else if (menuchoice.equals("2")) {
                //Return to existing character
                String character = ms.getCharacterSelection(ms);
                if (character != null) {
                    int choice = ms.playOrDelete(character);
                    if (choice == 1) {
                        //play game

                    } else if (choice == 2) {
                        // delete character
                    }
                }
            } else if (menuchoice.equals("3")) {
                //Exit Game
                inGame = false;
                System.out.println("Thanks for playing!");
            } else {
                System.out.println("\nInvalid Input!\n");
                MainMenu.main(args);
                }
            }
        }
    }

