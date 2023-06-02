
import Controller.*;
import Model.*;

public class Run {

    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        University university = new University("Example University");

        // Створення факультету
        Faculty faculty = FacultyCreator.createFaculty("Computer Science");
        university.setFaculty(faculty);

        // Створення кафедри
        Department department = DepartmentCreator.createDepartment("Software Engineering");
        faculty.setDepartment(department);

        // Створення групи
        Group group = GroupCreator.createGroup("SE-101");
        department.setGroup(group);

        // Створення студента
        Student student = StudentCreator.createStudent("John", "Doe", "Smith", Sex.MALE);
        group.setStudent(student);

        // Вивід інформації про університет
        System.out.println("University: " + university.getName());
        System.out.println("Faculty: " + university.getFaculty().getName());
        System.out.println("Department: " + university.getFaculty().getDepartment().getName());
        System.out.println("Group: " + university.getFaculty().getDepartment().getGroup().getName());
        System.out.println("Student: " + university.getFaculty().getDepartment().getGroup().getStudent().getFirstName()
                + " " + university.getFaculty().getDepartment().getGroup().getStudent().getLastName());
    }
}
