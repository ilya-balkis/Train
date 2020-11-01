package entity.man.impl;

import entity.man.Human;
import entity.man.Role;

public class Passenger extends Human {
    private final int numberOfTicket;

    private Passenger(String firstName, String secondName, String middleName, int age, int numberOfTicket) {
        super(firstName, secondName, middleName, age, Role.PASSENGER);
        this.numberOfTicket = numberOfTicket;
    }

    public static Passenger ofPassenger(String firstName, String secondName, String middleName, int age, int numberOfTicket) {
        return new Passenger(firstName, secondName, middleName, age, numberOfTicket);
    }

    @Override
    public String toString() {
        return super.getRole() + " {" +
                "Second name: " + super.getSecondName() +
                ", First name: " + super.getFirstName() +
                ", Middle name: " + super.getMiddleName() +
                ", Age: " + super.getAge() +
                ", Number of ticket: " + numberOfTicket +
                '}';
    }
}
