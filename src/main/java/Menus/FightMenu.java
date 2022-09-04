package Menus;

import Model.Player;

import java.util.Scanner;

public class FightMenu {

    public FightMenu() {

    }

    public static void doFightMenu(Player p) {
        System.out.println("\n1. Trivial Encounter\n2. Common Encounter\n3. Uncommon Encounter\n4. Rare Encounter\n5. Epic Encounter\n6. Legendary Encounter\n7. Exit");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equals("1")) {
            //Fight a trivial monster
        } else if (choice.equals("3")) {
            //Fight a common monster
        } else if (choice.equals("4")) {
            //Fight a common monster
        } else if (choice.equals("5")) {
            //Fight a common monster
        } else if (choice.equals("6")) {
            //Fight a common monster
        } else if (choice.equals("7")) {
            //Do nothing
        } else {
            System.out.println("\nInvalid Input! Please type a number from the selection.");
            FightMenu.doFightMenu(p);
        }
    }
}


