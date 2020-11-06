package entity.carriage.impl;

import entity.carriage.Carriage;
import entity.man.impl.Driver;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Locomotive extends Carriage {
    private Driver driver;

    private Locomotive(int numberOfWheels){
        super(numberOfWheels);
    }

    public static Locomotive of(int numberOfWheels) {
        return new Locomotive(numberOfWheels);
    }

    public boolean setDriver(Driver driver) {
        if (driver.getAge() > 18) {
            this.driver = driver;
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
