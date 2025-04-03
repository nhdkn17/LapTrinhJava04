package Universityms.DAO;

import Universityms.JDBC.JDBCUntil;
import Universityms.ms.Class;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private static final Connection conn = JDBCUntil.getConnection();

    public static void addClass(Class cls) {
        String sql = "INSERT INTO Class (classId, description, numberOfCredits) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, cls.getClassId());
            pstm.setString(2, cls.getDescription());
            pstm.setInt(3, cls.getNumberOfCredits());
            pstm.executeUpdate();
            System.out.println("Thêm lớp học thành công!");
        } catch (SQLException e) {
            System.out.println("Không thể thêm lớp! Vui lòng thử lại!");
        }
    }

    public static void updateClass(Class cls) {
        String sql = "UPDATE Class SET description=?, numberOfCredits=? WHERE classId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cls.getDescription());
            stmt.setInt(2, cls.getNumberOfCredits());
            stmt.setString(3, cls.getClassId());
            stmt.executeUpdate();
            System.out.println("Cập nhật lớp học thành công!");
        } catch (SQLException e) {
            System.out.println("Cập nhật lớp học không thành công!");
        }
    }

    public static void deleteClass(String classId) {
        String sql = "DELETE FROM Class WHERE classId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classId);
            stmt.executeUpdate();
            System.out.println("Xóa lớp học thành công!");
        } catch (SQLException e) {
            System.out.println("Xóa lớp không thành công!");
        }
    }

    public static List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM Class";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                classes.add(new Class(
                        rs.getString("classId"),
                        rs.getString("description"),
                        rs.getInt("numberOfCredits")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Không tìm thấy danh sách!");
        }
        return classes;
    }

    public static Class getClassById(String classId) {
        String sql = "SELECT * FROM Class WHERE classId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Class(
                        rs.getString("classId"),
                        rs.getString("description"),
                        rs.getInt("numberOfCredits")
                );
            }
        } catch (SQLException e) {
            System.out.println("Không tìm thấy lớp học!");
        }
        return null;
    }
}
