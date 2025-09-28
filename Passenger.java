public class Passenger implements PassengerRequirements{
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void boardCar(Car c){
        Boolean if_full = c.addPassenger(this);
        if (if_full){
            System.out.println(name + "Successfully boarded car " +  c );
        } else {
            System.out.println("Hello " + name + "! This car is full, please choose another car.");
        }
    }
    public void getOffCar(Car c){
        Boolean if_off = c.removePassenger(this);
        if (if_off){
            System.out.println("You have arrived.");
        } else {
            System.out.println( name + "is not on this car");
        }
    }
}
