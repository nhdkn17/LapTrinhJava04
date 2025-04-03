package Universityms.JDBC;

import java.sql.Connection;

import static Universityms.JDBC.JDBCUntil.getConnection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Kết nối thành công!");
        }
    }
}
