package Universityms.ms;

public class Class {
    private String classId;
    private String description;
    private int numberOfCredits;

    public Class(String classId, String description, int numberOfCredits) {
        this.classId = classId;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public Class() {
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", description='" + description + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                '}';
    }
}
