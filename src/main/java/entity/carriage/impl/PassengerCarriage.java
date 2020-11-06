package entity.carriage.impl;

import entity.carriage.Carriage;
import entity.man.Human;
import entity.man.impl.Passenger;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class PassengerCarriage extends Carriage {
    private static final int SETS = 3;
    private List<Human> passengers = new ArrayList<>();
    private int occupiedSeats = 0;

    private PassengerCarriage(int numberOfWheels){
        super(numberOfWheels);
    }

    public static PassengerCarriage of(int numberOfWheels){
        return new PassengerCarriage(numberOfWheels);
    }

    public boolean addPassenger(Passenger passenger) {
        if (occupiedSeats + 1 <= SETS) {
            passengers.add(passenger);
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
