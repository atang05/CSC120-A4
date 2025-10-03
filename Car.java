/**
 * The car class construct car objects carrying passengers with required methods. 
 */
import java.util.ArrayList;

public class Car implements CarRequirements{

    //Attributes
    private ArrayList<Passenger> passengers;
    private int max_capacity;

    /** 
     * Constructor for car, initialize the passenger on car and its maximum capacity
     * @param max_capacity The maximum capacity of passenger in car
     */
    public Car(int max_capacity){
        this.max_capacity = max_capacity;
        this.passengers = new ArrayList<>(max_capacity); // set the maximum number of item in this list as the max capacity of the car
    }

    /** 
     * give access to the max capacity of car
     * @return the number of passengers the car can carry at its maximum. 
     */
    public int getCapacity(){
        return this.max_capacity;
    }

    /** 
     * give access to the remaining seats in the car
     * @return the number of available seats in the car
     */ 
    public int seatsRemaining(){
        return this.max_capacity - passengers.size(); // use the max capacity minus seats taken to calculate the number of remaining seats
    }

    /** 
     * add passangers to the car
     * @param p the passanger added
     * @return if the passenger has been successfully added to the car, return true if passenger is added and return false if there are no seats available or the passenger is already on board.
     */   
    public Boolean addPassenger(Passenger p){
        if (passengers.contains(p)){ // check if the passengers is already on board before adding them to the car
            System.out.println(p.getName()+ " is already on board.");
            return false;
        }
        if (seatsRemaining() > 0){ // checks if there are available seats
            this.passengers.add(p); 
            return true;
        } else {
            System.out.println("No available seats in this car now."); 
            return false;
        }
    }


    /** 
     * removes passangers from the car
     * @param p the passanger needs to be removed
     * @return if the passenger has been successfully removed from the car, return true if passenger is removed and return false if the passenger is not on the car
     */  
    public Boolean removePassenger(Passenger p){
        if (passengers.contains(p)){ // checks if the passenger that needs to be removed is on board
            passengers.remove(p);
            return true;
        } else {
            System.out.println(p.getName() + " is not on board.");
            return false;
        }

    }

    /** 
     * print the list of passengers on car
     */  
    public void printManifest(){
        if (passengers.size() >0){
            for (int i = 0; i < passengers.size(); i++){
                System.out.println(passengers.get(i).getName()); // use the accessor to get the passengers' names on the car
            }
        }else{
            System.out.println("This car is EMPTY."); 
        }
    }

    // This method aims to test the methods in the car class.
    public static void main(String[] args){
        Car car = new Car(5);

        System.out.println("The max capacity of this car is " + car.getCapacity());

        Passenger passenger1 = new Passenger("Amy");
        Passenger passenger2 = new Passenger("Cola");
        Passenger passenger3 = new Passenger("Xinke");
        Passenger passenger4 = new Passenger("Yuhan");

        car.addPassenger(passenger1);
        car.addPassenger(passenger2);
        car.addPassenger(passenger3);

        System.out.println("The current capacity of this car is " + car.seatsRemaining() + "\n");

        System.out.println("Current manifest:");
        car.printManifest();

        car.removePassenger(passenger1);

        System.out.println("\nAfter removing, updated manifest:");
        car.printManifest();

        car.removePassenger(passenger1);

        car.addPassenger(passenger4);

        System.out.println("\nAfter adding, updated manifest:");
        car.printManifest();
    }



}