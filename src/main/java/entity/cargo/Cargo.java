package entity.cargo;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class Cargo {
    @NonNull
    private final float weight;
    @NonNull
    private final String name;
    @NonNull
    private final float size;
    @NonNull
    private final Destination destination;

    Cargo(float weight, String name, float size, Destination destination) {
        this.weight = weight;
        this.name = name;
        this.size = size;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "CARGO {" +
                "Weight: " + weight +
                ", Name: " + name +
                ", Size: " + size +
                ", Destination: " + destination +
                '}';
    }
}
