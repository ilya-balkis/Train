package entity.man;

import static com.google.common.base.Preconditions.checkArgument;
import lombok.Getter;

@Getter
public abstract class Human {
    private final String firstName;
    private final String secondName;
    private final String middleName;
    private final String placeOfBirth;
    private int age;

    public Human(String firstName, String secondName, String middleName, String placeOfBirth, int age) {
        checkArgument(age > 0, "Age cannot be negative.");
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.placeOfBirth = placeOfBirth;
        this.age = age;
    }

    public void setAge(int age) {
        checkArgument(age > 0, "Age cannot be negative.");
        this.age = age;
    }
}
