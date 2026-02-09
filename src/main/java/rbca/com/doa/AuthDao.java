package rbca.com.doa;
import java.sql.*;

import rbca.com.db.DBconnection;

public class AuthDao{

    public static int validateUser(String username, String password) {
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT role_id FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("role_id");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}

