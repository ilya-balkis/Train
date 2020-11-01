package entity.carriage.impl;

import entity.cargo.Cargo;
import entity.carriage.Carriage;

import java.util.ArrayList;
import java.util.List;

public class FreightCarriage extends Carriage {
    private static final float MAX_TOTAL_WEIGHT = 1000f;
    private List<Cargo> cargos = new ArrayList<>();
    private float totalWeight = 0;

    private FreightCarriage(int numberOfWheels){
        super(numberOfWheels);
    }

    public static FreightCarriage ofFreightCarriage(int numberOfWheels) {
        return new FreightCarriage(numberOfWheels);
    }

    public boolean addCargo(Cargo cargo) {
        if (totalWeight + cargo.getWeight() <= MAX_TOTAL_WEIGHT) {
            cargos.add(cargo);
            totalWeight += cargo.getWeight();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FreightCarriage {" +
                "cargos=" + cargos +
                '}';
    }
}
