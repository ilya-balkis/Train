package entity.train;

import static com.google.common.base.Preconditions.checkArgument;
import entity.carriage.Carriage;
import entity.carriage.impl.Locomotive;
import entity.man.impl.Driver;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private static final int NUMBER_OF_LOCOMOTIVE_WHEELS = 14;
    private final Locomotive locomotive = Locomotive.of(NUMBER_OF_LOCOMOTIVE_WHEELS);
    private Carriage head;
    private Carriage lastCarriage;
    private List<Carriage> carriages = new ArrayList<>();

    private Train(Driver driver) {
        locomotive.setDriver(driver);
        head = locomotive;
        lastCarriage = head;
    }

    public static Train of(Driver driver){
        return new Train(driver);
    }

    public boolean addCarriage(Carriage carriage) {
        checkArgument(carriage != null, "Carriage cannot be null");
        checkArgument(!(carriage instanceof Locomotive), "The train already has a locomotive.");
        checkArgument(carriage.getHead() == null && carriage.getTail() == null, "Carriage must be alone.");
        lastCarriage.setTail(carriage);
        carriage.setHead(lastCarriage);
        lastCarriage = carriage;
        return true;
    }

    public List<Carriage> getFullTrain() {
        if (!carriages.isEmpty()) {
            carriages.clear();
        }
        Carriage currentCarriage = head;
        System.out.println("Train:");
        while (currentCarriage != null) {
            carriages.add(currentCarriage);
            currentCarriage = currentCarriage.getTail();
        }
        return List.copyOf(carriages);
    }
}
