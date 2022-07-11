package jdbc_test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTest {


    private static String driverclass = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "system";
    private static String password = "12345";

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Connection conn = null;

        try {

            Class.forName(driverclass);
            conn = DriverManager.getConnection(url, username, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}