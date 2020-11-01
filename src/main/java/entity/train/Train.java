package entity.train;

import com.google.common.base.Preconditions;
import entity.carriage.Carriage;
import entity.carriage.impl.Locomotive;
import entity.man.impl.Driver;

public class Train {
    private static final int NUMBER_OF_LOCOMOTIVE_WHEELS = 14;
    private final Locomotive locomotive = Locomotive.ofLocomotive(NUMBER_OF_LOCOMOTIVE_WHEELS);
    private Carriage head;
    private Carriage lastCarriage;

    private Train(Driver driver) {
        locomotive.setDriver(driver);
        head = locomotive;
        lastCarriage = head;
    }

    public static Train ofTrain(Driver driver){
        return new Train(driver);
    }

    // I wanted to check Preconditions :)
    public boolean addCarriage(Carriage carriage) {
        Preconditions.checkArgument(!(carriage instanceof Locomotive), "The train already has a locomotive.");
        Preconditions.checkArgument(carriage.getHead() == null && carriage.getTail() == null, "Carriage must be alone.");
        lastCarriage.setTail(carriage);
        carriage.setHead(lastCarriage);
        lastCarriage = carriage;
        return true;
    }

    public void printTrain() {
        Carriage currentCarriage = head;
        int counter = 0;
        System.out.println("Train:");
        while (currentCarriage != null) {
            System.out.println("Carriage [" + ++counter + "]: " + currentCarriage);
            currentCarriage = currentCarriage.getTail();
        }
    }
}
