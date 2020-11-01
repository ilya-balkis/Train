package entity.carriage.impl;

import entity.carriage.Carriage;
import entity.man.Human;
import entity.man.impl.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerCarriage extends Carriage {
    private static final int SETS = 3;
    private List<Human> passengers = new ArrayList<>();
    private int occupiedSeats = 0;

    private PassengerCarriage(int numberOfWheels){
        super(numberOfWheels);
    }

    public static PassengerCarriage ofPassengerCarriage(int numberOfWheels){
        return new PassengerCarriage(numberOfWheels);
    }

    public boolean addPassenger(Human human) {
        if (human instanceof Passenger && occupiedSeats + 1 <= SETS) {
            passengers.add(human);
            occupiedSeats++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PassengerCarriage {" +
                "passengers=" + passengers +
                '}';
    }
}
