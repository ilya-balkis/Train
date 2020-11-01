package entity.carriage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Carriage {
    private final int numberOfWheels;
    private Carriage head = null;
    private Carriage tail = null;

    public Carriage(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}

