package entity.man;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Human {
    private String firstName;
    private String secondName;
    private String middleName;
    private int age;
    private Role role;

    public Human() {
    }

    public Human(String firstName, String secondName, String middleName, int age, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.age = age;
        this.role = role;
    }
}
