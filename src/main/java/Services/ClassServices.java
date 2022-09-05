package Services;

import Model.Player;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassServices {
    static Connection conn = ConnectionUtil.getConnection();

    public static int getClassHealDie (Player p) {
        int healdie = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            healdie = rs.getInt("healdie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healdie;
    }

    public static int getClassAddToDMGDie (Player p) {
        int addtodmgdie = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            addtodmgdie = rs.getInt("addtodmgdie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addtodmgdie;
    }

    public static int getClassAddToHitMax (Player p) {
        int maxaddtohit = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            maxaddtohit = rs.getInt("maxaddtohit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxaddtohit;
    }

    public static int getClassDMGDie (Player p) {
        int dmgdie = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            dmgdie = rs.getInt("dmgdie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dmgdie;
    }
    public static int getClassAcMax (Player p) {
        int ac = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            ac = rs.getInt("maxac");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ac;
    }
    public static int getClassHpDie (Player p) {
        int hp = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classstats where classname = ?");
            ps.setString(1,p.getClas());
            ResultSet rs = ps.executeQuery();
            rs.next();
            hp = rs.getInt("hpdie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hp;
    }
}
