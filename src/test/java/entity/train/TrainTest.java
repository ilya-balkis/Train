package entity.train;

import entity.carriage.Carriage;
import entity.carriage.impl.FreightCarriage;
import entity.carriage.impl.Locomotive;
import entity.carriage.impl.PassengerCarriage;
import entity.man.impl.Driver;
import entity.man.impl.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    private Train train;
    private static Driver driver;
    private static Locomotive locomotive;

    @BeforeAll
    static void initialize() {
        driver = Driver.of("Petr", "Petrov", "Petrovich", "Tokyo", 54, 18);
        locomotive = Locomotive.of(16);
    }

    @BeforeEach
    void setUp() {
        train = Train.of(driver);
    }

    @Test
    @DisplayName("Adding locomotive into train")
    void addCarriage_addLocomotiveToTrain_exception() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            train.addCarriage(locomotive);
        });
    }

    @Test
    @DisplayName("Adding null into train")
    void addCarriage_addNullToTrain_exception() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            train.addCarriage(null);
        });
    }

    @Test
    @DisplayName("Adding not empty carriage into train")
    void addCarriage_addNotEmptyCarriageToTrain_exception() throws IllegalArgumentException {
        PassengerCarriage firstCarriage = PassengerCarriage.of(16);
        PassengerCarriage secondCarriage = PassengerCarriage.of(16);

        firstCarriage.setTail(secondCarriage);

        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            train.addCarriage(firstCarriage);
        });
    }

    @Test
    @DisplayName("Adding carriage into train")
    void addCarriage_addCarriageToTrain_true() {
        PassengerCarriage firstCarriage = PassengerCarriage.of(16);
        boolean expected = true;
        boolean actual;

        actual = train.addCarriage(firstCarriage);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking train receipt")
    void getFullTrain_getTrain_listOfCarriages() {
        List<Carriage> expected = new ArrayList<>();
        List<Carriage> actual;
        Locomotive locomotive = Locomotive.of(18);
        PassengerCarriage firstCarriage = PassengerCarriage.of(16);
        FreightCarriage secondCarriage = FreightCarriage.of(16);

        locomotive.setDriver(driver);
        expected.add(locomotive);
        expected.add(firstCarriage);
        expected.add(secondCarriage);

        train.addCarriage(firstCarriage);
        train.addCarriage(secondCarriage);

        actual = train.getFullTrain();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}