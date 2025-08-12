package FirstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteUpdate {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/learn_jdbc";
        String username = "postgres";
        String password = "865200";

        Connection con = DriverManager.getConnection(url, username, password);

        String sql = String.format("""
               INSERT INTO users VALUES (%d, '%s', %d)
               """, 4, "Koko4", 15);
        PreparedStatement ps = con.prepareStatement(sql);
        int rowAffected = ps.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("Insert successful");
        }


        else {
            System.out.println("Insert failed");
        }
    }
}
