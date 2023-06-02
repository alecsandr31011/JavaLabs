package Model;

public class Department {
    private String name;
    private Group group;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
