import entity.cargo.Cargo;
import entity.cargo.Destination;
import entity.carriage.impl.FreightCarriage;
import entity.carriage.impl.Locomotive;
import entity.carriage.impl.PassengerCarriage;
import entity.man.impl.Driver;
import entity.man.impl.Passenger;
import entity.train.Train;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {

        Passenger passenger = Passenger.of("Ivan", "Ivanov", "Ivanovich", "Moscow", 23, 301);
        log.info("Create passenger: {}", passenger);
        passenger.setAge(24);
        log.info("Set passenger age: {}", passenger);

        Cargo firstCargo = Cargo.builder()
                .destination(Destination.MINSK)
                .name("Mouse")
                .size(12)
                .weight(800)
                .build();
        log.info("Create first cargo: {}", firstCargo);
        Cargo secondCargo = Cargo.builder()
                .destination(Destination.MINSK)
                .name("Dog")
                .size(50)
                .weight(300)
                .build();
        log.info("Create second cargo: {}", secondCargo);

        Driver driver = Driver.of("Petr", "Petrov", "Petrovich", "Minsk", 54, 18);
        log.info("Create driver {}", driver);

        Locomotive locomotive = Locomotive.of(14);
        log.info("Create locomotive: {}", locomotive);
        locomotive.setDriver(driver);
        log.info("Set locomotive driver: {}", locomotive);

        PassengerCarriage passengerCarriage = PassengerCarriage.of(16);
        log.info("Create passenger carriage: {}", passengerCarriage);
        passengerCarriage.addPassenger(passenger);
        log.info("Add passenger to passenger carriage: {}", passengerCarriage);

        FreightCarriage freightCarriage = FreightCarriage.of(16);
        log.info("Create freight carriage: {}", freightCarriage);
        boolean addedCargo;
        addedCargo = freightCarriage.addCargo(firstCargo);
        log.info("Is first cargo added: {}", addedCargo);
        addedCargo = freightCarriage.addCargo(secondCargo);
        log.info("Is second cargo added: {}", addedCargo);
        log.info("Freight carriage after adding cargos: {}", freightCarriage);

        Train train = Train.of(driver);
        log.info("Create train: {}", train);

        train.addCarriage(passengerCarriage);
        train.addCarriage(freightCarriage);
        log.info("Carriages were added");
        System.out.println(train.getFullTrain());
        log.info("Train was printed");

        log.info("Try to add locomotive into train");
        train.addCarriage(locomotive);
        log.info("Locomotive was added");
    }
}
