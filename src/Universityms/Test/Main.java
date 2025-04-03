package Universityms.Test;

import Universityms.ms.Student;
import Universityms.DAO.StudentDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Cập nhật sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Xem danh sách sinh viên");
            System.out.println("5. Tìm sinh viên theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    StudentDAO.addStudent(new Student(id, name, age, email, gpa));
                    break;
                case 2:
                    System.out.print("Nhập ID sinh viên cần cập nhật: ");
                    id = scanner.nextLine();
                    Student s = StudentDAO.getStudentById(id);
                    if (s == null) {
                        System.out.println("Không tìm thấy sinh viên!");
                        break;
                    }
                    System.out.print("Nhập tên mới: ");
                    s.setName(scanner.nextLine());
                    System.out.print("Nhập tuổi mới: ");
                    s.setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nhập email mới: ");
                    s.setEmail(scanner.nextLine());
                    System.out.print("Nhập GPA mới: ");
                    s.setGpa(scanner.nextFloat());
                    scanner.nextLine();
                    StudentDAO.updateStudent(s);
                    break;
                case 3:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    id = scanner.nextLine();
                    StudentDAO.deleteStudent(id);
                    break;
                case 4:
                    System.out.println("\nDanh sách sinh viên:");
                    for (Student student : StudentDAO.getAllStudents()) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID sinh viên: ");
                    id = scanner.nextLine();
                    s = StudentDAO.getStudentById(id);
                    System.out.println(s != null ? s : "Không tìm thấy sinh viên!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
