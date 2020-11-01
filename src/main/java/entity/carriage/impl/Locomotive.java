package entity.carriage.impl;

import entity.carriage.Carriage;
import entity.man.Human;
import entity.man.impl.Driver;

public class Locomotive extends Carriage {
    private Driver driver;

    private Locomotive(int numberOfWheels){
        super(numberOfWheels);
    }

    public static Locomotive ofLocomotive(int numberOfWheels) {
        return new Locomotive(numberOfWheels);
    }

    public boolean setDriver(Human human) {
        if (human instanceof Driver) {
            driver = (Driver) human;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Locomotive {" +
                driver +
                '}';
    }
}
