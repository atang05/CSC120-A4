public class Engine implements EngineRequirements{
    private FuelType fuel_type;
    private double max_fuel_level;
    private double current_fuel_level;

    public Engine(FuelType fuel_type,double max_fuel_level, double current_fuel_level){
        this.fuel_type = fuel_type;
        this.max_fuel_level = max_fuel_level;
        this.current_fuel_level = current_fuel_level;
    }

    public FuelType getFuelType(){
        return this.fuel_type;
    }

    
    public double getMaxFuel(){
        return this.max_fuel_level;
    }
    
    public double getCurrentFuel(){
        return this.current_fuel_level;
    } 
    
    public void refuel(){
        this.current_fuel_level = max_fuel_level;
        System.out.println("Engine refueled to " + max_fuel_level);
    }

    public Boolean go(){
        if (current_fuel_level > 0){
            current_fuel_level -= 5.0;
            if (current_fuel_level < 0){
                current_fuel_level = 0;
            }
                System.out.println("Fuel remaining:" + current_fuel_level);
                return current_fuel_level > 0;
            } else {
                return false;
            }
        

        }
    

        public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}
