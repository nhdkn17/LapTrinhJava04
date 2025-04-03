package Universityms.DAO;

import Universityms.JDBC.JDBCUntil;
import Universityms.ms.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final Connection conn = JDBCUntil.getConnection();

    public static void addStudent(Student student) {
        String sql = "INSERT INTO Student (studentId, studentName, age, email, gpa) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, student.getStudentId());
            pstm.setString(2, student.getName());
            pstm.setInt(3, student.getAge());
            pstm.setString(4, student.getEmail());
            pstm.setFloat(5, student.getGpa());
            pstm.executeUpdate();
            System.out.println("Thêm sinh viên thành công!");
        } catch (SQLException e) {
            System.out.println("Chưa thể thêm sinh viên! Vui lòng thử lại!");
        }
    }

    public static void updateStudent(Student student) {
        String sql = "UPDATE Student SET studentName=?, age=?, email=?, gpa=? WHERE studentId=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, student.getName());
            pstm.setInt(2, student.getAge());
            pstm.setString(3, student.getEmail());
            pstm.setDouble(4, student.getGpa());
            pstm.setString(5, student.getStudentId());
            pstm.executeUpdate();
            System.out.println("Cập nhật sinh viên thành công!");
        } catch (SQLException e) {
            System.out.println("Cập nhật sinh viên thất bại!");
        }
    }

    public static void deleteStudent(String studentId) {
        String sql = "DELETE FROM Student WHERE studentId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentId);
            stmt.executeUpdate();
            System.out.println("Xóa sinh viên thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa sinh viên: ");
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Statement pstm = conn.createStatement();
             ResultSet rs = pstm.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getString("studentId"),
                        rs.getString("studentName"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getFloat("gpa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách sinh viên!");
        }
        return students;
    }

    public static Student getStudentById(String id) {
        String sql = "SELECT * FROM Student WHERE studentId=?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("studentId"),
                        rs.getString("studentName"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getFloat("gpa")
                );
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm sinh viên: ");
        }
        return null;
    }
}