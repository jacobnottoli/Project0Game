package Services;

import Model.Monster;
import Model.Player;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonsterServices {
    Connection conn;
    public MonsterServices() {
        conn = ConnectionUtil.getConnection();
    }

    public Monster getMonsterFromTable(int num, String type) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from monsters where num = ? and enctype = ?");
            ps.setString(1, String.valueOf(num));
            ps.setString(2, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Monster m = new Monster(rs.getString("name"),rs.getInt("hp"),rs.getInt("ac"),rs.getInt("numroll"),rs.getInt("dmg"),rs.getInt("addtodmg"),rs.getInt("addtohit"),rs.getInt("xp"),rs.getInt("coin"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
