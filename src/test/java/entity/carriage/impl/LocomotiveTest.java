package entity.carriage.impl;

import entity.man.impl.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocomotiveTest {

    private Locomotive locomotive;

    @BeforeEach
    void setUp() {
        locomotive = Locomotive.of(16);
    }

    @Test
    @DisplayName("Adding driver with age that more than 18")
    public void setDriver_addDriverToLocomotive_true() {
        Driver driver = Driver.of("Petr", "Petrov", "Petrovich", "Tokyo", 54, 18);
        boolean expected = true;
        boolean actual;

        actual = locomotive.setDriver(driver);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding driver with age that less than 18")
    public void setDriver_addDriverToLocomotive_false() throws IllegalArgumentException{
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Driver driver = Driver.of("Petr", "Petrov", "Petrovich", "Tokyo", 17, 18);
        });
    }

}