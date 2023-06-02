package Controller;

import Model.*;
public class DepartmentCreator {
    public static Department createDepartment(String name) {
        return new Department(name);
    }
}
