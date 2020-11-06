package entity.man.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    @DisplayName("Creating driver with age that less than 18")
    void of_createNewDriverWithIncorrectAge_exception() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Driver driver = Driver.of("Petr", "Petrov", "Petrovich", "Tokyo", 16, 18);
        });
    }

    @Test
    @DisplayName("Creating driver with negative experience")
    void of_createNewDriverWithIncorrectExperience_exception() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Driver driver = Driver.of("Petr", "Petrov", "Petrovich", "Tokyo", 54, -18);
        });
    }
}