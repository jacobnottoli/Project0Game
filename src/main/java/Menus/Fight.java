package Menus;

import Model.Monster;
import Model.Player;
import Model.Roll;
import Services.UpdatePlayer;

import java.util.Scanner;

public class Fight {
    public Fight () {

    }

    public static void doFight(Player p, Monster m) {
        while (p.getHp()>0 && m.getHp()>0) {
            System.out.println("\n" + p.getName() + "'s HP: " + p.getHp());
            System.out.println(p.getName() + "'s AC: " + p.getAc());
            System.out.println("\n"+ m.getName() + "'s HP: " + m.getHp());
            System.out.println(m.getName() + "'s AC: " + m.getAc());
            int selection = Fight.fightPrompt(p);
            if (selection == 1) {
                int attackroll = Roll.attackRoll(p.getAddtohit());
                System.out.println("You rolled a " + attackroll + " to hit!");
                if (attackroll >= m.getAc()) {
                    int dmg = Roll.doDamage((p.getLvl()/3)+1,p.getDmg(),p.getAddtodmg());
                    System.out.println("You hit for " + dmg + " damage!");
                    m.setHp(m.getHp()-dmg);
                } else {
                    System.out.println("Your attack missed...");
                }
            } else {
                int heal = Roll.doHeal(p.getHeal());
                p.setHp(p.getHp()+heal);
                if (p.getHp()>p.getMaxhp()) {
                    p.setHp(p.getMaxhp());
                }
                System.out.println("You heal yourself " + heal + " hit points!");
            }
            if (m.getHp() > 0) {
                int mattackroll = Roll.attackRoll(m.getAddtohit());
                System.out.println("\n" + m.getName() + " attacks! It rolls a " + mattackroll + " to hit!");
                if (mattackroll >= p.getAc()) {
                    int mdmg = Roll.doDamage(m.getNumroll(),m.getDmg(),m.getAddtodmg());
                    System.out.println(m.getName() + " hits for " + mdmg + " damage!");
                    p.setHp(p.getHp()-mdmg);
                } else {
                    System.out.println(m.getName() + " missed their attack!");
                }
            }

        }

        if (p.getHp() <= 0) {
            System.out.println("\nYou have died... Better luck next time...");
            p.setHp(p.getMaxhp());
        } else {
            System.out.println("\n The " + m.getName() + " has been defeated! Congratulations!");
            UpdatePlayer.afterFightPlayerUpdate(p,m.getXp(),m.getCoin());

        }
    }
    public static int fightPrompt(Player p) {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1.Use " + p.getAtkname() +"\n2. Heal");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid Input!");
            Fight.fightPrompt(p);
        } else {
            return choice;
        }
        return 1;
    }
}
