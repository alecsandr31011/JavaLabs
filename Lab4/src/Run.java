import Controller.*;
import Model.*;


public class Run {

    public static void main(String[] args) {
        createTypicalUniversity();
        testJsonSerialization();
    }

    public static void createTypicalUniversity() {
        University university = new University("Example University");

        // Створення факультету
        Faculty faculty = FacultyCreator.createFaculty("Computer Science");
        university.setFaculty(faculty);

        // Створення кафедр
        Department department1 = DepartmentCreator.createDepartment("Software Engineering");
        Department department2 = DepartmentCreator.createDepartment("Data Science");
        faculty.setDepartment(department1);
        faculty.setDepartment(department2);

        // Створення груп
        Group group1 = GroupCreator.createGroup("SE-101");
        Group group2 = GroupCreator.createGroup("DS-201");
        department1.setGroup(group1);
        department1.setGroup(group2);

        // Створення студентів
        Student student1 = StudentCreator.createStudent("John", "Doe", "Smith", Sex.MALE);
        Student student2 = StudentCreator.createStudent("Jane", "Smith", "Doe", Sex.FEMALE);
        Student student3 = StudentCreator.createStudent("David", "Johnson", "Williams", Sex.MALE);
        Student student4 = StudentCreator.createStudent("Emily", "Brown", "Taylor", Sex.FEMALE);
        group1.setStudent(student1);
        group1.setStudent(student2);
        group2.setStudent(student3);
        group2.setStudent(student4);

        // Запис університету в форматі JSON
        JsonManager.writeUniversityToJson(university);
    }

    public static void testJsonSerialization() {
        // Зчитування університету з файлу у форматі JSON
        University oldUniversity = JsonManager.readUniversityFromJson();

        // Створення нового університету для порівняння
        University newUniversity = new University("Example University");

        // Створення факультетів
        Faculty faculty1 = FacultyCreator.createFaculty("Computer Science");
        Faculty faculty2 = FacultyCreator.createFaculty("Data Science");
        newUniversity.setFaculty(faculty1);
        newUniversity.setFaculty(faculty2);

        // Створення кафедр
        Department department1 = DepartmentCreator.createDepartment("Software Engineering");
        Department department2 = DepartmentCreator.createDepartment("Data Analysis");
        faculty1.setDepartment(department1);
        faculty2.setDepartment(department2);

        // Створення груп
        Group group1 = GroupCreator.createGroup("SE-101");
        Group group2 = GroupCreator.createGroup("DA-201");
        department1.setGroup(group1);
        department2.setGroup(group2);

        // Створення студентів
        Student student1 = StudentCreator.createStudent("John", "Doe", "Smith", Sex.MALE);
        Student student2 = StudentCreator.createStudent("Jane", "Smith", "Doe", Sex.FEMALE);
        Student student3 = StudentCreator.createStudent("David", "Johnson", "Williams", Sex.MALE);
        Student student4 = StudentCreator.createStudent("Emily", "Brown", "Taylor", Sex.FEMALE);
        group1.setStudent(student1);
        group1.setStudent(student2);
        group2.setStudent(student3);
        group2.setStudent(student4);

        // Порівняння університетів
        boolean isEqual = oldUniversity.equals(newUniversity);
        System.out.println("Are universities equal? " + isEqual);
    }
}
