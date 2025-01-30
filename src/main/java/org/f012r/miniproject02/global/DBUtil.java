package org.f012r.miniproject02.global;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/todolist";
        String user = "todolist";
        String password = "0000";
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {e.printStackTrace(); }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {e.printStackTrace();}
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {e.printStackTrace(); }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {e.printStackTrace();}
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {e.printStackTrace();}
        }
    }
}
