package rbca.com.dao;
import java.sql.*;

import rbca.com.db.DBconnection;

public class Permission {

    public static boolean canView(int roleId,String table,String column) {
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
              "SELECT view FROM permissions WHERE role_id=? AND table_name=? AND column_name=?"
            );
            ps.setInt(1,roleId);
            ps.setString(2,table);
            ps.setString(3,column);

            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getBoolean("view");

        } catch(Exception e){e.printStackTrace();}
        return false;
    }

    public static boolean canEdit(int roleId,String table,String column) {
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
              "SELECT edit FROM permissions WHERE role_id=? AND table_name=? AND column_name=?"
            );
            ps.setInt(1,roleId);
            ps.setString(2,table);
            ps.setString(3,column);

            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getBoolean("edit");

        } catch(Exception e){e.printStackTrace();}
        return false;
    }
}
