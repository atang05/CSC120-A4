import java.util.ArrayList;

public class Train implements TrainRequirements{
    private ArrayList<Car> cars;
    private Engine engine;

    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++){
            cars.add(new Car(passengerCapacity));
        }
    }
    public Engine getEngine(){
        return this.engine;
    }
    public Car getCar(int i){
        if (i >= 0 & i < cars.size()){
            return cars.get(i);
        }
        return null;
    }

    public int getMaxCapacity(){
        return cars.size() * (cars.get(0).getCapacity());

    }
    public int seatsRemaining(){
        int remaining = 0;
        for (int i = 0; i < cars.size(); i++){
            remaining += cars.get(i).seatsRemaining();
        }
        return remaining;
    }
    public void printManifest(){
        System.out.println("Train Manifest:");
        for (int i = 0; i< cars.size(); i++){
            System.out.println("Car"+(i+1)+":");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 50.0,100.0, 3, 5);
        Passenger p1 = new Passenger("Joyce");
        Passenger p2 = new Passenger("Liang");
        Passenger p3 = new Passenger("Xitong");

        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);
        train.getCar(2).addPassenger(p3);

        System.out.println("Train Engine Details:");
        System.out.println(train.getEngine());
        System.out.println("Train Max Capacity: "+ train.getMaxCapacity());
        System.out.println("Available Seats: "+ train.seatsRemaining());
        train.printManifest();
    }

}
