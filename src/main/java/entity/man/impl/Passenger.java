package entity.man.impl;

import entity.man.Human;

import static com.google.common.base.Preconditions.checkArgument;

public class Passenger extends Human {
    private final int numberOfTicket;

    private Passenger(String firstName, String secondName, String middleName, String placeOfBirth, int age, int numberOfTicket) {
        super(firstName, secondName, middleName, placeOfBirth, age);
        this.numberOfTicket = numberOfTicket;
    }

    public static Passenger of(String firstName, String secondName, String middleName, String placeOfBirth, int age, int numberOfTicket) {
        checkArgument(numberOfTicket > 0, "Number of ticket cannot be negative");
        return new Passenger(firstName, secondName, middleName, placeOfBirth, age, numberOfTicket);
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName().toUpperCase() + " {" +
                "Second name: " + super.getSecondName() +
                ", First name: " + super.getFirstName() +
                ", Middle name: " + super.getMiddleName() +
                ", Place of Birth: " + super.getPlaceOfBirth() +
                ", Age: " + super.getAge() +
                ", Number of ticket: " + numberOfTicket +
                '}';
    }
}
