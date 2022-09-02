package Services;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MenuServices {
    Connection conn;
    Scanner in = new Scanner(System.in);
    public MenuServices() {
        conn = ConnectionUtil.getConnection();
    }
    public int playOrDelete(String name) {
        System.out.println("What would you like to do with " + name + "?\n1.Play\n2.Delete");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            return 1;
        } else if (choice.equals("2")) {
            System.out.println("Are you sure you want to delete this character? If yes, please type 'CONFIRM'");
            String confirm = in.nextLine();
            if (confirm.equals("CONFIRM")) {
                return 2;
            } else {
                return 3;
            }
        }
        return 3;
    }
    public String getCharacterSelection(MenuServices ms)  {
        System.out.println("Choose your character by typing the name of the character you want. Type 'back' to return to the menu\n");
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select name, lvl, class from players");
            Set<String> names = new HashSet<>();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + " Lvl " + rs.getInt("lvl") + " " + rs.getString("class"));
                names.add(rs.getString("name"));
            }

            String selection = in.nextLine();
            if (selection.equals("back")) {
                return null;
            } else if (names.contains(selection)) {
                return selection;
            } else {
                System.out.println("\nInvalid Input! Please enter the name of the character you want to select!\n");
                ms.getCharacterSelection(ms);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
