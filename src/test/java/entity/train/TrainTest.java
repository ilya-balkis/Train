package entity.train;

import entity.carriage.Carriage;
import entity.carriage.impl.Locomotive;
import entity.carriage.impl.PassengerCarriage;
import entity.man.impl.Driver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainTest {

    private Train train;
    private Carriage correctCarriage;
    private Carriage incorrectCarriage;
    private Carriage locomotive;
    private Driver driver;

    @Before
    public void initialize() {
        driver = Driver.ofDriver("Petr", "Petrov", "Petrovich", 54, 18);
        train = Train.ofTrain(driver);
        correctCarriage = PassengerCarriage.ofPassengerCarriage(16);
        incorrectCarriage = PassengerCarriage.ofPassengerCarriage(16);
        incorrectCarriage.setHead(correctCarriage);
        locomotive = Locomotive.ofLocomotive(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCarriage_addLocomotiveToTrain_exception() {
        train.addCarriage(locomotive);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCarriage_addIncorrectCarriageToTrain_exception() {
        train.addCarriage(incorrectCarriage);
    }

    @Test
    public void addCarriage_addCorrectCarriageToTrain_true() {
        boolean expected = true;
        boolean actual;
        actual = train.addCarriage(correctCarriage);
        assertEquals(expected, actual);
    }
}