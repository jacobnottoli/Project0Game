package Services;

import Model.Player;
import Repository.PlayerRepository;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlayerServices {
    Connection conn;
    Scanner in = new Scanner(System.in);
    PlayerRepository pr;
    public PlayerServices() {
        conn = ConnectionUtil.getConnection();
        pr = new PlayerRepository();
    }

    public Player getPlayerFromTable(String name) {
        Connection conn = ConnectionUtil.getConnection();
        Player p;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from players where name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Player(rs.getString("name"),rs.getString("class"),rs.getInt("hp"),rs.getInt("maxhp"),rs.getInt("ac"),rs.getInt("dmg"),rs.getInt("addtodmg"),rs.getInt("addtohit"),rs.getInt("heal"),rs.getString("atkname"),rs.getInt("lvl"),rs.getInt("xp"),rs.getInt("coin"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletePlayer(String name) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("delete from players where name = ?");
            ps.setString(1,name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addPlayer(Player p) {
        Player test = pr.getPlayerByName(p.getName());
        if (test == null) {
            pr.addPlayer(p);
        } else {
            System.out.println("Invalid Player! Two players cannot have the same name. Please try again!");
        }
    }

    public Player chooseClass(PlayerServices ps) {
        System.out.println("Welcome adventurer! What is your name?\n");
        String name = in.nextLine();
        System.out.println("What type of adventurer are you?\n1. Mage");
        System.out.println("2. Warrior");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            //Create Mage
            return ps.createMage(ps,name);
        } else if (choice.equals("2")) {
            //Create Warrior
            return ps.createWarrior(ps,name);
        } else {
            System.out.println("\nInvalid Input!\n");
            ps.chooseClass(ps);
        }
        return null;
    }
    public Player createMage(PlayerServices ps, String name) {
        System.out.println("Ahhh... An adventurer of the arcane! Would you like to be a Fire or Frost Mage?\n");
        System.out.println("1. Fire Mage\n2. Frost Mage");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            //Create Fire Mage
           return ps.createFireMage(name);
        } else if (choice.equals("2")) {
            //Create Frost Mage
            return ps.createFrostMage(name);
        } else {
            System.out.println("\nInvalid Input!\n");
            ps.createMage(ps, name);
        }
        return null;
    }

    public Player createWarrior(PlayerServices ps, String name) {
        System.out.println("Ahhh... An adventurer of the brawn! Would you like to be One Handed or Two Handed?\n");
        System.out.println("1. One Handed Warrior\n2. Two Handed Warrior");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            //Create One Handed Warrior
            return ps.createOneHandedWarrior(name);
        } else if (choice.equals("2")) {
            //Create Two Handed Warrior
            return ps.createTwoHandedWarrior(name);
        } else {
            System.out.println("\nInvalid Input!\n");
            ps.createWarrior(ps, name);
        }
        return null;
    }

    public Player createFireMage(String name) {
        return new Player(name,"Fire Mage",6,6,12,12,6,4,6,"Fireball",1,0,0);
    }
    public Player createFrostMage(String name) {
        return new Player(name,"Frost Mage",6,6,12,10,4,6,6,"Ice Shard",1,0,0);
    }
    public Player createOneHandedWarrior(String name) {
        return new Player(name,"One Handed Warrior",10,10,17,8,4,6,4,"Sword",1,0,0);
    }
    public Player createTwoHandedWarrior(String name) {

        return new Player(name,"Two Handed Warrior",10,10,15,12,6,5,4,"Greatsword",1,0,0);
    }
}
