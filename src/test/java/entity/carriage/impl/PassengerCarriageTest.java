package entity.carriage.impl;

import entity.man.impl.Driver;
import entity.man.impl.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerCarriageTest {

    private PassengerCarriage passengerCarriage;
    private Passenger firstPassenger;
    private Passenger secondPassenger;
    private Passenger thirdPassenger;
    private Passenger fourthPassenger;
    private Driver driver;

    @Before
    public void initialize() {
        passengerCarriage = PassengerCarriage.ofPassengerCarriage(16);
        firstPassenger = Passenger.ofPassenger("Ivan", "Ivanov", "Ivanovich", 23, 301);
        secondPassenger = Passenger.ofPassenger("Egor", "Egorov", "Egorovich", 20, 200);
        thirdPassenger = Passenger.ofPassenger("Victor", "Victorov", "Victorovich", 17, 505);
        fourthPassenger = Passenger.ofPassenger("Dmitry", "Dmitrov", "Dmitriev", 67, 400);
        driver = Driver.ofDriver("Petr", "Petrov", "Petrovich", 54, 18);
    }

    @Test
    public void addPassenger_addDriverToPassengerCarriage_false() {
        boolean expected = false;
        boolean actual;
        actual = passengerCarriage.addPassenger(driver);
        assertEquals(expected, actual);
    }

    @Test
    public void addPassenger_addPassengerToPassengerCarriage_true() {
        boolean expected = true;
        boolean actual;
        actual = passengerCarriage.addPassenger(firstPassenger);
        assertEquals(expected, actual);
    }

    @Test
    public void addPassenger_addExtraPassengerToPassengerCarriage_false() {
        boolean expected = false;
        boolean actual;
        actual = passengerCarriage.addPassenger(firstPassenger);
        actual = passengerCarriage.addPassenger(secondPassenger);
        actual = passengerCarriage.addPassenger(thirdPassenger);
        actual = passengerCarriage.addPassenger(fourthPassenger);
        assertEquals(expected, actual);
    }
}