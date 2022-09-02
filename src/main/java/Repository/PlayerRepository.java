package Repository;

import Model.Player;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRepository {
    Connection conn;
    public PlayerRepository() {
        conn = ConnectionUtil.getConnection();
    }

    public void addPlayer(Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into players(name,class,hp,maxhp,ac,dmg,addtodmg,addtohit,heal,atkname,lvl,xp,coin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getClas());
            ps.setInt(3, p.getHp());
            ps.setInt(4,p.getMaxhp());
            ps.setInt(5,p.getAc());
            ps.setInt(6,p.getDmg());
            ps.setInt(7,p.getAddtodmg());
            ps.setInt(8,p.getAddtohit());
            ps.setInt(9,p.getHeal());
            ps.setString(10,p.getAtkname());
            ps.setInt(11,p.getLvl());
            ps.setInt(12,p.getXp());
            ps.setInt(13,p.getCoin());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayerByName(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from players where name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Player p = new Player(rs.getString("name"), rs.getString("class"),rs.getInt("hp"),rs.getInt("maxhp"),rs.getInt("ac"),rs.getInt("dmg"),rs.getInt("addtodmg"),rs.getInt("addtohit"),rs.getInt("heal"),rs.getString("atkname"),rs.getInt("lvl"),rs.getInt("xp"),rs.getInt("coin"));
                return p;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
