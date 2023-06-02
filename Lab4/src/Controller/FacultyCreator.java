package Controller;

import Model.*;
public class FacultyCreator {
    public static Faculty createFaculty(String name) {
        return new Faculty(name);
    }
}
