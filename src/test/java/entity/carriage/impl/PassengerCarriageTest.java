package entity.carriage.impl;

import entity.man.impl.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassengerCarriageTest {

    private PassengerCarriage passengerCarriage;

    @BeforeEach
    void setUp() {
        passengerCarriage = PassengerCarriage.of(16);
    }

    @Test
    @DisplayName("Adding a passenger to a carriage with free seats")
    public void addPassenger_addPassengerToPassengerCarriage_true() {
        Passenger firstPassenger = Passenger.of("Ivan", "Ivanov", "Ivanovich", "Mogilev",23, 301);
        boolean expected = true;
        boolean actual;

        actual = passengerCarriage.addPassenger(firstPassenger);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding a passenger to a carriage without free seats")
    public void addPassenger_addPassengerToPassengerCarriage_false() {
        Passenger firstPassenger = Passenger.of("Ivan", "Ivanov", "Ivanovich", "Mogilev",23, 301);
        Passenger secondPassenger = Passenger.of("Egor", "Egorov", "Egorovich", "Moscow", 20, 200);
        Passenger thirdPassenger = Passenger.of("Victor", "Victorov", "Victorovich", "Minsk", 17, 505);
        Passenger fourthPassenger = Passenger.of("Dmitry", "Dmitrov", "Dmitriev", "New York", 67, 400);
        boolean expected = false;
        boolean actual;

        actual = passengerCarriage.addPassenger(firstPassenger);
        actual = passengerCarriage.addPassenger(secondPassenger);
        actual = passengerCarriage.addPassenger(thirdPassenger);
        actual = passengerCarriage.addPassenger(fourthPassenger);

        assertEquals(expected, actual);
    }


}