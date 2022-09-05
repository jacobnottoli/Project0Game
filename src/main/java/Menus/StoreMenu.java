package Menus;

import Model.Player;
import Services.ClassServices;
import Services.MenuServices;
import Services.UpdatePlayer;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class StoreMenu {
    Connection conn = ConnectionUtil.getConnection();
    public static void doStoreMenu(Player p) {
        boolean inStoreMenu = true;
        while (inStoreMenu) {
            System.out.println("\nWelcome to the store! Choose an option below! Your current gold: " + p.getCoin());
            System.out.println("1. Upgrade Health Points -- 15 gold");
            System.out.println("2. Upgrade Armor Class -- 30 gold");
            System.out.println("3. Upgrade Damage -- 20 gold");
            System.out.println("4. Upgrade Add to Hit Bonus -- 25 gold");
            System.out.println("5. Upgrade Add to Damage -- 25 gold");
            System.out.println("6. Upgrade Heal -- 15 gold");
            System.out.println("7. Bulk Store Menu");
            System.out.println("8. Exit Store");
            Scanner in = new Scanner(System.in);
            MenuServices ms = new MenuServices();
            int smchoice = in.nextInt();
            if (smchoice == 1) {
                if (p.getCoin() >= 15) {
                    p.setCoin(p.getCoin()-15);
                    p.setHp(p.getHp()+(ClassServices.getClassHpDie(p)/2));
                    p.setMaxhp(p.getMaxhp()+(ClassServices.getClassHpDie(p)/2));
                    UpdatePlayer.updatePlayerHP(p);
                    UpdatePlayer.updatePlayerMaxHP(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (smchoice == 2) {
                if (p.getAc() >= ClassServices.getClassAcMax(p)) {
                    System.out.println("Cannot complete purchase! Player's Armor class is already maxed out!");
                } else {
                    if (p.getCoin() >= 30) {
                        p.setCoin(p.getCoin()-30);
                        p.setAc(p.getAc()+1);
                        UpdatePlayer.updatePlayerAC(p);
                        UpdatePlayer.updatePlayerCoin(p);
                    } else {
                        System.out.println("You do not have enough gold for this upgrade!");
                }

                }
            } else if (smchoice == 3) {
                if (p.getCoin() >= 20) {
                    p.setCoin(p.getCoin()-20);
                    p.setDmg(p.getDmg()+(ClassServices.getClassDMGDie(p)/2));
                    UpdatePlayer.updatePlayerDMG(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (smchoice == 4) {
                if (p.getAddtohit() >= ClassServices.getClassAddToHitMax(p)) {
                    System.out.println("Cannot complete purchase! Player's Add to hit is already maxed out!");
                } else {
                    if (p.getCoin() >= 25) {
                        p.setCoin(p.getCoin()-25);
                        p.setAddtohit(p.getAddtohit()+1);
                        UpdatePlayer.updatePlayerAddToHit(p);
                        UpdatePlayer.updatePlayerCoin(p);
                    } else {
                        System.out.println("You do not have enough gold for this upgrade!");
                    }

                }
            } else if (smchoice == 5) {
                if (p.getCoin() >= 25) {
                    p.setCoin(p.getCoin()-25);
                    p.setAddtodmg(p.getAddtodmg()+(ClassServices.getClassAddToDMGDie(p)/2));
                    UpdatePlayer.updatePlayerAddToDmg(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (smchoice == 6) {
                if (p.getCoin() >= 15) {
                    p.setCoin(p.getCoin()-15);
                    p.setHeal(p.getHeal()+(ClassServices.getClassHealDie(p)/2));
                    UpdatePlayer.updatePlayerHeal(p);
                    UpdatePlayer.updatePlayerCoin(p);
                } else {
                    System.out.println("You do not have enough gold for this upgrade!");
                }
            } else if (smchoice == 7) {
                BulkStoreMenu.doBulkStoreMenu(p);
            }  else if (smchoice == 8) {
                inStoreMenu = false;
            } else {
                System.out.println("\nInvalid Choice! Please pick a valid number.\n");
                StoreMenu.doStoreMenu(p);
            }

        }
    }
}


