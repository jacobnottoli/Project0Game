import Menus.GameMenu;
import Model.Player;
import Services.MenuServices;
import Services.PlayerServices;
import Services.UpdatePlayer;

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
            GameMenu gm = new GameMenu();
            Player p;
            if (menuchoice.equals("1")) {
                //Create Character
                p = ps.chooseClass(ps);
                ps.addPlayer(p);
                gm.theGameMenu(p,gm);
            } else if (menuchoice.equals("2")) {
                //Return to existing character
                String character = ms.getCharacterSelection(ms);
                if (character != null) {
                    int choice = ms.playOrDelete(character);
                    if (choice == 1) {
                        //play game
                        gm.theGameMenu(ps.getPlayerFromTable(character),gm);
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

