package jdbc_test.common;

import java.sql.*;

//DB 연결과 종료

public class JDBCutil {
    //필드
    private static String driverClass = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "system";
    private static String password = "12345";


    //DB 연결 메서드
    public static Connection getConnection() {
        try {
            Class.forName(driverClass);
            System.out.println("DB 연결");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    //DB연결 종료 메서드


    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                System.out.println("DB 연결 끊음");
                pstmt.close();
            }
            if (conn != null) {
                System.out.println("DB 연결 끊음");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        try {
            if (rs != null) {
                System.out.println("DB 연결 끊음");
                rs.close();
            }
            if (pstmt != null) {
                System.out.println("DB 연결 끊음");
                pstmt.close();
            }
            if (conn != null) {
                System.out.println("DB 연결 끊음");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
