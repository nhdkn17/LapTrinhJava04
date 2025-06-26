package Lambda_Stream;

import java.util.*;
import java.util.stream.*;

public class StudentStreamDemo {
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An", 85),
                new Student("Bình", 45),
                new Student("Cường", 73),
                new Student("Dương", 50),
                new Student("Hà", 90),
                new Student("Linh", 39)
        );

        // BÀI 1
        System.out.println("== BÀI 1: Học sinh có điểm cao nhất ==");
        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingInt(Student::getScore));

        topStudent.ifPresent(s ->
                System.out.println("Học sinh điểm cao nhất: " + s.getName() + " - " + s.getScore())
        );

        // BÀI 2
        System.out.println("\n== BÀI 2: Điểm trung bình của lớp ==");
        double averageScore = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);

        System.out.printf("Điểm trung bình: %.2f\n", averageScore);

        // BÀI 3
        System.out.println("\n== BÀI 3: Phân loại học sinh ==");
        Map<String, List<Student>> ketQua = students.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Đậu" : "Rớt"));

        System.out.println("Danh sách Đậu:");
        ketQua.getOrDefault("Đậu", new ArrayList<>())
                .forEach(System.out::println);

        System.out.println("\nDanh sách Rớt:");
        ketQua.getOrDefault("Rớt", new ArrayList<>())
                .forEach(System.out::println);
    }
}
