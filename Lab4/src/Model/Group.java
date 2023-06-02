package Model;

public class Group {
    private String name;
    private Student student;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
