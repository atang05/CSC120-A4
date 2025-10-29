/**
 * The Engine class represents an engine running with specified fuel types and fuel level.
 */
public class Engine implements EngineRequirements{

    // attributes
    private FuelType fuel_type;
    private double max_fuel_level;
    private double current_fuel_level;

    /**
    * The constructor that builds engine objects with given fuel type, fuel level. // miss type the fuel level or type level
    * @param fuel_type takes in the type of fuel engine uses including selection from STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER
    * @param max_fuel_level engines' maximum level of fuel
    * @param current_fuel_level engines' current level of fuel
    */
    public Engine(FuelType fuel_type,double max_fuel_level, double current_fuel_level){
        this.fuel_type = fuel_type;
        this.max_fuel_level = max_fuel_level;
        this.current_fuel_level = current_fuel_level;
    }

    /**
     * Returns the fuel type the engine uses
     * @return the fuel type of the engine
     */
    public FuelType getFuelType(){
        return this.fuel_type;
    }

    /**
     * Returns the max fuel level of the engine
     * @return the max fuel level
     */
    public double getMaxFuel(){
        return this.max_fuel_level;
    }

    /**
     * Returns the current fuel level of the engine
     * @return the current level of the fuel of the engine
     */
    public double getCurrentFuel(){
        return this.current_fuel_level;
    } 
    
    /**
     * Refuel the engine to its maximum fuel level
     */
    public void refuel(){
        this.current_fuel_level = max_fuel_level; //set the current fuel level to maximum
        System.out.println("Engine refueled to " + max_fuel_level);
    }

    /**
     * Checks if the engine have enough fuel to run. If there is, then decrease fuel level by 5 and return true else return false
     * @return true if there are fuel left in the engine after running, otherwise false
     */
    public Boolean go(){
        if (current_fuel_level > 0){ //check if the fuel type is greater than zero
            current_fuel_level -= 5.0; // everytime it goes fuel level decrease by 5
            if (current_fuel_level < 0){ //check if there still have fuel
                current_fuel_level = 0;// set the fuel level to zero since fuel level can't be negative
            }
                System.out.println("Fuel remaining:" + current_fuel_level);//print the current fuel level after running
                return current_fuel_level > 0;//return true if fuel level greater than zero and return false if less or equal to zero
        } else {
            return false;
            }
        }
    

    /**
     * This main method tests all the method in the Engine class
     */
    public static void main(String[] args) {
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 0.0); // the order of input is reversed, now corrected
    while (myEngine.go()) {
        System.out.println("Choo choo!");
    }
    System.out.println("Out of fuel.");
    }
}
