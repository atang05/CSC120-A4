/**
 * The Train class connects all of the car, passenger and the engine.
 */
import java.util.ArrayList;

public class Train implements TrainRequirements{
    //Attributes
    private ArrayList<Car> cars;
    private Engine engine;


    /**
    * The constructor that builds the Train objects with given fuelType, fuelLevel, fuelCapacity, number of cars and the passenegr capacity.
    * @param fuelType the fuel type of the Engine
    * @param currentFuelLevel the current fuel level of the Engine
    * @param fuelCapacity the fuel capacity of the Engine
    * @param nCars the number of cars
    * @param passengerCapacity the passenger capacity of the car
    */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++){
            cars.add(new Car(passengerCapacity));
        }
    }
    
    /**
    * access engine information about the car
    * @return the engine information about the car
    */
    public Engine getEngine(){
        return this.engine;
    }
    
    /**
    * access a single car object in the arraylist of cars
    * @param i the order of the car of arraylist named cars
    * @return the single car object
    */
    public Car getCar(int i){
        if (i >= 0 & i < cars.size()){
            return cars.get(i);
        }
        return null;
    }

    /**
    * get the maximum capacity of the train
    * @return the maximum capacity of the train
    */
    public int getMaxCapacity(){//
        return cars.size() * (cars.get(0).getCapacity());//the number of the car times each car's capacit
    }

    /**
    * check the remaining seats
    * @return the remaining seats
    */
    public int seatsRemaining(){
        int remaining = 0;//set the remaining at 0
        for (int i = 0; i < cars.size(); i++){
            remaining += cars.get(i).seatsRemaining();//calculation process
        }
        return remaining;
    }

    /**
    * print all of the passenger's name in all of the cars
    */
    public void printManifest(){
        System.out.println("Train Manifest:");//the title
        for (int i = 0; i< cars.size(); i++){
            System.out.println("Car"+(i+1)+":");
            cars.get(i).printManifest();
        }
    }

    /**
     * This main method tests all the method in the Train class
     */
    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 50.0,100.0, 3, 5);
        Passenger p1 = new Passenger("Emily");
        Passenger p2 = new Passenger("Lu");
        Passenger p3 = new Passenger("He");
        Passenger p4 = new Passenger("Chen");

        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);
        train.getCar(2).addPassenger(p3);
        train.getCar(2).addPassenger(p4);

        System.out.println("Train Engine Details:");
        System.out.println(train.getEngine());
        System.out.println(train.getCar(1));
        System.out.println("Train Max Capacity: "+ train.getMaxCapacity());
        System.out.println("Available Seats: "+ train.seatsRemaining());
        train.printManifest();
    }

}
