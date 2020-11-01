package entity.carriage.impl;

import entity.man.impl.Driver;
import entity.man.impl.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocomotiveTest {

    private Locomotive locomotive;
    private Driver driver;
    private Passenger passenger;

    @Before
    public void initialize() {
        locomotive = Locomotive.ofLocomotive(14);
        driver = Driver.ofDriver("Petr", "Petrov", "Petrovich", 54, 18);
        passenger = Passenger.ofPassenger("Ivan", "Ivanov", "Ivanovich", 23, 301);
    }

    @Test
    public void setDriver_addDriverToLocomotive_true() {
        boolean expected = true;
        boolean actual;
        actual = locomotive.setDriver(driver);
        assertEquals(expected, actual);
    }

    @Test
    public void setDriver_addPassengerToLocomotive_false() {
        boolean expected = false;
        boolean actual;
        actual = locomotive.setDriver(passenger);
        assertEquals(expected, actual);
    }
}