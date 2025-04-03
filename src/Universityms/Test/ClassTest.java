package Universityms.Test;

import Universityms.ms.Class;
import Universityms.DAO.ClassDAO;

import java.util.Scanner;

public class ClassTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== QUẢN LÝ LỚP HỌC ===");
            System.out.println("1. Thêm lớp học");
            System.out.println("2. Cập nhật lớp học");
            System.out.println("3. Xóa lớp học");
            System.out.println("4. Xem danh sách lớp học");
            System.out.println("5. Tìm lớp học theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID lớp: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập mô tả lớp: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    ClassDAO.addClass(new Class(id, description, credits));
                    break;
                case 2:
                    System.out.print("Nhập ID lớp cần cập nhật: ");
                    id = scanner.nextLine();
                    Class cls = ClassDAO.getClassById(id);
                    if (cls == null) {
                        System.out.println("Không tìm thấy lớp học!");
                        break;
                    }
                    System.out.print("Nhập mô tả mới: ");
                    cls.setDescription(scanner.nextLine());
                    System.out.print("Nhập số tín chỉ mới: ");
                    cls.setNumberOfCredits(scanner.nextInt());
                    scanner.nextLine();
                    ClassDAO.updateClass(cls);
                    break;
                case 3:
                    System.out.print("Nhập ID lớp cần xóa: ");
                    id = scanner.nextLine();
                    ClassDAO.deleteClass(id);
                    break;
                case 4:
                    System.out.println("\nDanh sách lớp học:");
                    for (Class clsItem : ClassDAO.getAllClasses()) {
                        System.out.println(clsItem);
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID lớp: ");
                    id = scanner.nextLine();
                    cls = ClassDAO.getClassById(id);
                    System.out.println(cls != null ? cls : "Không tìm thấy lớp học!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}

