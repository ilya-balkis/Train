package entity.man;

import entity.man.impl.Passenger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTest {

    @Test
    @DisplayName("Setting negative age")
    void setAge_SetNegativeAge_exception() throws IllegalArgumentException{
        Human human = Passenger.of("Ivan", "Ivanov", "Ivanovich", "Mogilev",12, 301);
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            human.setAge(-16);
        });
    }
}