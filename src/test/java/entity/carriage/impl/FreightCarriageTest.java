package entity.carriage.impl;

import entity.cargo.Cargo;
import entity.cargo.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreightCarriageTest {

    private FreightCarriage freightCarriage;

    @BeforeEach
    void setUp() {
        freightCarriage = FreightCarriage.of(16);
    }

    @Test
    @DisplayName("Adding cargo with a suitable weight")
    void addCargo_addCargoToListOfCargos_true() {
        Cargo firstCargo = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("first cargo")
                .build();
        boolean expected = true;
        boolean actual;

        actual = freightCarriage.addCargo(firstCargo);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding cargo with an unsuitable weight")
    void addCargo_addCargoToListOfCargos_false() {
        Cargo firstCargo = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("first cargo")
                .build();
        Cargo secondCargo = Cargo.builder()
                .destination(Destination.MINSK)
                .size(20)
                .weight(400)
                .name("second cargo")
                .build();
        boolean expected = false;
        boolean actual;

        actual = freightCarriage.addCargo(firstCargo);
        actual = freightCarriage.addCargo(secondCargo);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing cargo that is in the carriage")
    void removeCargo_removeCargoFromListOfCargos_true() {
        Cargo cargoInCarriage = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("name")
                .build();
        Cargo removableCargo = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("name")
                .build();
        boolean expected = true;
        boolean actual;

        freightCarriage.addCargo(cargoInCarriage);
        actual = freightCarriage.removeCargo(removableCargo);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing cargo that is not in the carriage")
    void removeCargo_removeCargoFromListOfCargos_false() {
        Cargo cargoInCarriage = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("name")
                .build();
        Cargo removableCargo = Cargo.builder()
                .destination(Destination.KIEV)
                .size(19)
                .weight(400)
                .name("other name")
                .build();
        boolean expected = false;
        boolean actual;

        freightCarriage.addCargo(cargoInCarriage);
        actual = freightCarriage.removeCargo(removableCargo);

        assertEquals(expected, actual);
    }
}