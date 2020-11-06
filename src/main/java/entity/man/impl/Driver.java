package entity.man.impl;

import static com.google.common.base.Preconditions.checkArgument;
import entity.man.Human;

public class Driver extends Human {
    private static final int NO_EXPERIENCE = 0;
    private final int experience;

    private Driver(String firstName, String secondName, String middleName, String placeOfBirth, int age, int experience) {
        super(firstName, secondName, middleName, placeOfBirth, age);
        this.experience = experience;
    }

    public static Driver of(String firstName, String secondName, String middleName, String placeOfBirth, int age) {
        checkArgument(age > 18, "Age of driver must be more than 18.");
        return new Driver(firstName, secondName, middleName, placeOfBirth, age, NO_EXPERIENCE);
    }

    public static Driver of(String firstName, String secondName, String middleName, String placeOfBirth, int age, int experience) {
        checkArgument(age > 18, "Age of driver must be more than 18.");
        checkArgument(experience > 0, "Experience cannot be negative.");
        return new Driver(firstName, secondName, middleName, placeOfBirth, age, experience);
    }

    @Override
    public String toString() {
        return  super.getClass().getSimpleName().toUpperCase() + " {" +
                "Second Name: " + super.getSecondName() +
                ", First Name: " + super.getFirstName() +
                ", Middle Name: " + super.getMiddleName() +
                ", Place of Birth: " + super.getPlaceOfBirth() +
                ", Age: " + super.getAge() +
                ", Experience: " + experience +
                '}';
    }
}
