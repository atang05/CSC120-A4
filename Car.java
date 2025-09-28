import java.util.ArrayList;
public class Car implements CarRequirements{
    private ArrayList<Passenger> passengers;
    private int max_capacity;

    public Car(int max_capacity){
        this.max_capacity = max_capacity;
        this.passengers = new ArrayList<>();
    }

    public int getCapacity(){
        return this.max_capacity;
    }

    public int seatsRemaining(){
        return this.max_capacity - passengers.size();
    }
    
    public Boolean addPassenger(Passenger p){
        if (seatsRemaining() > 0){
            this.passengers.add(p);
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean removePassenger(Passenger p){
        if (passengers.contains(p)){
            passengers.remove(p);
            return true;
        } else {
            return false;
        }

    }

    public void printManifest(){
        if (passengers.size() > 0){
            System.out.println(passengers);
        } else {
            System.out.println("This car is EMPTY.");
        }

    }


}