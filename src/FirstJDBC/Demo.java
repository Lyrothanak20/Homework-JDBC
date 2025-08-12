package FirstJDBC;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/learn_jdbc";
        String username = "postgres";
        String password = "865200";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(con.getSchema());
        String sql = "select * from users";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Table table = new Table(
                3, BorderStyle.UNICODE_BOX_DOUBLE_BORDER
        );
        table.addCell("ID ");
        table.addCell("Name ");
        table.addCell("Age ");
        while(resultSet.next()){
            table.addCell(String.valueOf(resultSet.getInt("ID")));
            table.addCell(resultSet.getString("Name"));
            table.addCell(String.valueOf(resultSet.getInt("Age")));

        }
        System.out.println(table.render());
        con.close();
        statement.close();
        resultSet.close();

    }
}
