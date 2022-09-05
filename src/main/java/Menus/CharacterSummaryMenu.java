package Menus;

import Model.Player;

import java.util.Scanner;

public class CharacterSummaryMenu {
    public static void doSummaryMenu(Player p) {
        System.out.println("Here is a summary of your current character. Type anything to go back\n");
        System.out.println(p.getName() + " || Lvl " + p.getLvl() + " " + p.getClas());
        System.out.println("HP: " + p.getHp());
        System.out.println("AC: " + p.getAc());
        System.out.println("Add to hit bonus: " + p.getAddtohit());
        System.out.println("Number of damage rolls: " + ((p.getLvl()/3)+1));
        System.out.println("Damage range: " + p.getDmg());
        System.out.println("Damage added after roll: " + p.getAddtodmg());
        System.out.println("Heal range: " + p.getHeal());
        System.out.println("Total XP earned: " + p.getXp());
        System.out.println("Total gold: " + p.getCoin());
        Scanner in = new Scanner(System.in);
    }
}
