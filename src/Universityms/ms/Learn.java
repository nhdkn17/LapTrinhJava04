package Universityms.ms;

public class Learn {
    private String learnId;
    private String studentId;
    private String classId;

    public Learn(String learnId, String studentId, String classId) {
        this.learnId = learnId;
        this.studentId = studentId;
        this.classId = classId;
    }

    public Learn() {
    }

    public String getLearnId() {
        return learnId;
    }

    public void setLearnId(String learnId) {
        this.learnId = learnId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Learn{" +
                "learnId='" + learnId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
