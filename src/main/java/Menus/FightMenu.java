package Menus;

import Model.Player;
import Services.MonsterServices;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FightMenu {

    public FightMenu() {

    }

    public static void doFightMenu(Player p) {
        System.out.println("\n1. Trivial Encounter\n2. Common Encounter\n3. Uncommon Encounter\n4. Rare Encounter\n5. Epic Encounter\n6. Legendary Encounter\n7. Exit");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        MonsterServices ms = new MonsterServices();
        int whichmon = ThreadLocalRandom.current().nextInt(1,4);
        if (choice.equals("1")) {
            //Fight a trivial monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Trivial"));
        } else if (choice.equals("2")) {
            //Fight a common monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Common"));
        }else if (choice.equals("3")) {
            //Fight a common monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Uncommon"));
        } else if (choice.equals("4")) {
            //Fight a common monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Rare"));
        } else if (choice.equals("5")) {
            //Fight a common monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Epic"));
        } else if (choice.equals("6")) {
            //Fight a common monster
            Fight.doFight(p,ms.getMonsterFromTable(whichmon, "Legendary"));
        } else if (choice.equals("7")) {
            //Do nothing
        } else {
            System.out.println("\nInvalid Input! Please type a number from the selection.");
            FightMenu.doFightMenu(p);
        }
    }
}


