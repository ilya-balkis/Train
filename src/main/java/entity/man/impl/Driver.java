package entity.man.impl;

import entity.man.Human;
import entity.man.Role;

public class Driver extends Human {
    private static final int NO_EXPERIENCE = 0;
    private final int experience;

    private Driver(String firstName, String secondName, String middleName, int age, int experience) {
        super(firstName, secondName, middleName, age, Role.DRIVER);
        this.experience = experience;
    }

    public static Driver ofDriver(String firstName, String secondName, String middleName, int age) {
        return new Driver(firstName, secondName, middleName, age, NO_EXPERIENCE);
    }

    public static Driver ofDriver(String firstName, String secondName, String middleName, int age, int experience) {
        return new Driver(firstName, secondName, middleName, age, experience);
    }

    @Override
    public String toString() {
        return  super.getRole() + " {" +
                "Second Name: " + super.getSecondName() +
                ", First Name: " + super.getFirstName() +
                ", Middle Name: " + super.getMiddleName() +
                ", Age: " + super.getAge() +
                ", Experience: " + experience +
                '}';
    }
}
