package entity.carriage.impl;

import entity.cargo.Cargo;
import entity.carriage.Carriage;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class FreightCarriage extends Carriage {
    private static final double DEFAULT_WEIGHT = 1000;
    private List<Cargo> cargos = new ArrayList<>();
    private final double maxTotalWeight;

    private FreightCarriage(int numberOfWheels){
        super(numberOfWheels);
        this.maxTotalWeight = DEFAULT_WEIGHT;
    }

    private FreightCarriage(int numberOfWheels, double maxTotalWeight){
        super(numberOfWheels);
        this.maxTotalWeight = maxTotalWeight;
    }

    public static FreightCarriage of(int numberOfWheels) {
        return new FreightCarriage(numberOfWheels);
    }

    public static FreightCarriage of(int numberOfWheels, double maxTotalWeight) {
        return new FreightCarriage(numberOfWheels, maxTotalWeight);
    }

    public boolean addCargo(Cargo cargo) {
        double weight = cargos.stream().mapToDouble(Cargo::getWeight).sum();
        if (weight + cargo.getWeight() <= maxTotalWeight) {
            cargos.add(cargo);
            return true;
        }
        return false;
    }

    public boolean removeCargo(Cargo cargo) {
        if (cargos.contains(cargo)){
            cargos.remove(cargo);
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
