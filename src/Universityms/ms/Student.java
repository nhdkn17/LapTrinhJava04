package Universityms.ms;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private float gpa;

    public Student(String studentId, String name, int age, String email, float gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
