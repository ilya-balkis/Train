package entity.carriage.impl;

import entity.cargo.Cargo;
import entity.cargo.Destination;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreightCarriageTest {

    private FreightCarriage freightCarriage;
    private Cargo firstCargo;
    private Cargo secondCargo;

    @Before
    public void initialize() {
        freightCarriage = FreightCarriage.ofFreightCarriage(16);
        firstCargo = Cargo.builder()
                .destination(Destination.MOSCOW)
                .size(15)
                .weight(900)
                .name("first cargo")
                .build();
        secondCargo = Cargo.builder()
                .destination(Destination.MINSK)
                .size(20)
                .weight(400)
                .name("second cargo")
                .build();
    }

    @Test
    public void addCargo_addCargoToListOfCargos_true() {
        boolean expected = true;
        boolean actual;
        actual = freightCarriage.addCargo(firstCargo);
        assertEquals(expected, actual);
    }

    @Test
    public void addCargo_addCargoToListOfCargos_false() {
        boolean expected = false;
        boolean actual;
        actual = freightCarriage.addCargo(firstCargo);
        actual = freightCarriage.addCargo(secondCargo);
        assertEquals(expected, actual);
    }
}