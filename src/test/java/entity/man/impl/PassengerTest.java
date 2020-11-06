package entity.man.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PassengerTest {

    @Test
    @DisplayName("Creating passenger with negative number of ticket")
    void of_createNewPassenger_exception() throws IllegalArgumentException{
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Passenger firstPassenger = Passenger.of("Ivan", "Ivanov", "Ivanovich", "Mogilev",23, -100);
        });
    }
}