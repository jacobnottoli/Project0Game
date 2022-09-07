package Menus;

import Model.Player;
import Services.ClassServices;
import Services.UpdatePlayer;

import java.util.Scanner;

public class BulkStoreMenu {

    public static void doBulkStoreMenu (Player p) {
        boolean inBulkStore = true;
        while (inBulkStore) {
            System.out.println("Welcome to the bulk store! \nYou can either buy upgrades in sets of ten, or use all of your gold to buy as many of an upgrade as you can!");
            System.out.println("Your current gold: " + p.getCoin());
            System.out.println("1. BULK Upgrade Health Points (10) -- 150 gold");
            System.out.println("2. BULK Upgrade Health Points (" + p.getCoin()/15 + ") -- " + (p.getCoin()/15)*15 + " gold");
            System.out.println("3. BULK Upgrade Damage (10) -- 200 gold");
            System.out.println("4. BULK Upgrade Damage (" + p.getCoin()/20 + ") -- " + (p.getCoin()/20)*20 + " gold");
            System.out.println("5. BULK Upgrade Add to Damage (10) -- 250 gold");
            System.out.println("6. BULK Upgrade Add to Damage (" + p.getCoin()/25 + ") -- " + (p.getCoin()/25)*25 + " gold");
            System.out.println("7. BULK Upgrade Heal (10) -- 150 gold");
            System.out.println("8. BULK Upgrade Add to Damage (" + p.getCoin()/15 + ") -- " + (p.getCoin()/15)*15 + " gold");
            System.out.println("9. Exit Bulk Store");
            Scanner in = new Scanner(System.in);
            int bmchoice = in.nextInt();

            if (bmchoice == 1) {
                if (p.getCoin() >= 150) {
                    p.setCoin(p.getCoin()-150);
                    p.setHp(p.getHp()+10*(ClassServices.getClassHpDie(p)/2));
                    p.setMaxhp(p.getMaxhp()+10*(ClassServices.getClassHpDie(p)/2));
                    System.out.println("You gained " + (10 *(ClassServices.getClassHpDie(p)/2)) + " HP!");
                    UpdatePlayer.updatePlayerHP(p);
                    UpdatePlayer.updatePlayerMaxHP(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (bmchoice == 2) {
                p.setHp(p.getHp()+(p.getCoin()/15)*(ClassServices.getClassHpDie(p)/2));
                p.setMaxhp(p.getMaxhp()+((p.getCoin()/15)*(ClassServices.getClassHpDie(p)/2)));
                System.out.println("You gained " + ((p.getCoin()/15)*(ClassServices.getClassHpDie(p)/2)) + " HP!");
                p.setCoin(p.getCoin()-((p.getCoin()/15)*15));
                UpdatePlayer.updatePlayerHP(p);
                UpdatePlayer.updatePlayerMaxHP(p);
                UpdatePlayer.updatePlayerCoin(p);
            } else if (bmchoice == 3) {
                if (p.getCoin() >= 200) {
                    p.setCoin(p.getCoin()-200);
                    p.setDmg(p.getDmg()+10*(ClassServices.getClassDMGDie(p)/2));
                    System.out.println("You gained " + (20*(ClassServices.getClassDMGDie(p)/2)) + " to your damage range!");
                    UpdatePlayer.updatePlayerDMG(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (bmchoice == 4) {
                p.setDmg(p.getDmg()+(p.getCoin()/20)*(ClassServices.getClassDMGDie(p)/2));
                System.out.println("You gained " + ((p.getCoin()/20)*(ClassServices.getClassDMGDie(p)/2)) + " to your damage range!");
                p.setCoin(p.getCoin()-((p.getCoin()/20)*20));
                UpdatePlayer.updatePlayerDMG(p);
                UpdatePlayer.updatePlayerCoin(p);
            } else if (bmchoice == 5) {
                if (p.getCoin() >= 250) {
                    p.setCoin(p.getCoin()-250);
                    p.setAddtodmg(p.getAddtodmg()+10*(ClassServices.getClassAddToDMGDie(p)/2));
                    System.out.println("You gained " + (10*(ClassServices.getClassAddToDMGDie(p)/2)) + " to your add to damage!");
                    UpdatePlayer.updatePlayerAddToDmg(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (bmchoice == 6) {
                p.setAddtodmg(p.getAddtodmg()+(p.getCoin()/25)*(ClassServices.getClassAddToDMGDie(p)/2));
                System.out.println("You gained " + ((p.getCoin()/25)*(ClassServices.getClassAddToDMGDie(p)/2)) + " to your add to damage!");
                p.setCoin(p.getCoin()-((p.getCoin()/25)*25));
                UpdatePlayer.updatePlayerAddToDmg(p);
                UpdatePlayer.updatePlayerCoin(p);
            } else if (bmchoice == 7) {
                if (p.getCoin() >= 150) {
                    p.setCoin(p.getCoin()-150);
                    p.setHeal(p.getHeal()+10*(ClassServices.getClassHealDie(p)/2));
                    UpdatePlayer.updatePlayerHeal(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (bmchoice == 8)   {
                p.setHeal(p.getHeal()+(p.getCoin()/15)*(ClassServices.getClassHealDie(p)/2));
                System.out.println("You gained " + ((p.getCoin()/15)*(ClassServices.getClassHealDie(p)/2)) + " to your heal!");
                p.setCoin(p.getCoin()-((p.getCoin()/15)*15));
                UpdatePlayer.updatePlayerAddToDmg(p);
                UpdatePlayer.updatePlayerCoin(p);
            } else if (bmchoice == 9) {
                inBulkStore = false;
          ~  } else {
                System.out.println("\nInvalid Input! Please enter one of the numbers from the selection.");
                BulkStoreMenu.doBulkStoreMenu(p);
            }
        }

    }
}
