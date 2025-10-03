/**
 * The Passenger class represents all passengers and record the boarding and removing of passengers.
 */
public class Passenger implements PassengerRequirements{

    // attributes
    private String name;

    /**
    * The constructor that builds Passenger objects with given name.
    * @param name the name of the passenger
    */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * the boarding process, adding passenger after check the capacity of the car
     * @param c the car that user wants to add passenger to
     */
    public void boardCar(Car c){ 
        Boolean if_full = c.addPassenger(this); // checks if the car is full before let the passengrs board the car
        if (if_full){
            System.out.println(name + "Successfully boarded car " +  c );
        } else {
            System.out.println("Hello " + name + "! This car is full, please choose another car."); // returns corresponding error message if car is full
        }
    }

    /**
     * Remove passengers if the passenger want get off of the car and check if the passenger is on the car
     * @param c the car that user wants to get the passenger off
     */
    public void getOffCar(Car c){ 
        Boolean if_off = c.removePassenger(this);
        if (if_off){
            System.out.println("You have arrived."); // get the passanger off the car if the passenger is on the car
        } else {
            System.out.println(name + "is not on this car");
        }
    }

    /**
     * accessor to get name of the passenger
     * @return returns the passengers' names as string
     */
    public String getName() { 
        return name;
    }
}
