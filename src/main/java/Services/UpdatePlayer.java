package Services;

import Model.Player;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePlayer {
    static Connection conn = ConnectionUtil.getConnection();
    public UpdatePlayer () {
        Connection conn = ConnectionUtil.getConnection();
    }
    public static void updatePlayerHP (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set hp = ? where name = ?");
            ps.setInt(1,p.getMaxhp());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayerMaxHP (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set maxhp = ? where name = ?");
            ps.setInt(1,p.getMaxhp());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayerAC (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set ac = ? where name = ?");
            ps.setInt(1,p.getAc());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerDMG (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set dmg = ? where name = ?");
            ps.setInt(1,p.getDmg());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerAddToDmg (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set addtodmg = ? where name = ?");
            ps.setInt(1,p.getAddtodmg());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerAddToHit (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set addtohit = ? where name = ?");
            ps.setInt(1,p.getAddtohit());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerHeal (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set heal = ? where name = ?");
            ps.setInt(1,p.getHeal());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerXP (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set xp = ? where name = ?");
            ps.setInt(1,p.getXp());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePlayerCoin (Player p) {
        try {
            PreparedStatement ps = conn.prepareStatement("update players set coin = ? where name = ?");
            ps.setInt(1,p.getCoin());
            ps.setString(2,p.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afterFightPlayerUpdate(Player p, int xp, int coin) {
        p.setXp(p.getXp()+xp);
        UpdatePlayer.updatePlayerXP(p);
        p.setCoin(p.getCoin()+coin);
        UpdatePlayer.updatePlayerCoin(p);
        if (p.getLvl()!= ((p.getXp()/100)+1)) {
            //Level up!
            p.setLvl((p.getXp()/100)+1);
            //update health
            int healthdie = 0;
            try {
                PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
                ps.setString(1,p.getClas());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    healthdie = rs.getInt("hpdie");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            p.setMaxhp(p.getMaxhp()+healthdie);
        }
        p.setHp(p.getMaxhp());
        UpdatePlayer.updatePlayerMaxHP(p);
        UpdatePlayer.updatePlayerHP(p);
    }
}
