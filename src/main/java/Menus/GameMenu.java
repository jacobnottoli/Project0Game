package Menus;

import Model.Player;
import Services.MenuServices;

import java.util.Scanner;

public class GameMenu {
    public GameMenu () {
        MenuServices ms = new MenuServices();
        FightMenu fm = new FightMenu();
    }
    public void theGameMenu(Player p, GameMenu gm) {
        boolean inGameMenu = true;
        while (inGameMenu) {
            System.out.println(p.getName());
            System.out.println("1. Fight || 2. Store || 3. Character Summary || 4. Exit");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            if (choice.equals("1")) {
                //Monster Select Menu
                FightMenu.doFightMenu(p);
            } else if (choice.equals("2")) {
                //Store Menu
            } else if (choice.equals("3")) {
                //CharacterSummary
            } else if (choice.equals("4")) {
                //Exit
                inGameMenu = false;
            }else {
                System.out.println("\nInvalid Input! Please enter a number to proceed.\n");
                gm.theGameMenu(p,gm);
            }
        }
    }
}
