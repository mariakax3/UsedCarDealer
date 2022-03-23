import View.*;
import View.Fleet;

public class Main {
    public static void main(String[] args){
        FileDataSource fileDataSource = new FileDataSource(args[0]);
        FleetRepository repository = new FleetRepository(fileDataSource);

        Fleet fleet = new Fleet(repository);

        HomePanel home = new HomePanel();
        BuyPassengerCar buyPC = new BuyPassengerCar();
        SellPassengerCar sellPC = new SellPassengerCar(fleet);
        BuyTruck buyTruck = new BuyTruck();
        SellTruck sellTruck = new SellTruck(fleet);

        UI ui = new UI(fleet, home, buyPC, sellPC, buyTruck, sellTruck);
    }
}
