package FleetOfVehicle;

public class Bus extends Vehicle{
    protected int passenger;

    public Bus(String make, String model, int year, double mileage, String licensePlate, String fuelType, int passenger) {
        super(make, model, year, mileage, licensePlate, fuelType);
        this.passenger = passenger;
   }

   public int getPassenger() {
        return passenger;
   }

   public int setPassenger(int passenger) {
        return passenger;
   }

   public String Print(){
        return ("Make: " + getMake() + " Model: " + getModel() + " Year: " + getYear() + " Mileage: " + getMileage() +
               " License Plate: " + getLicensePlate() + " Fuel Type: " + getFuelType() + " Passenger: " + this.getPassenger());
   }

}
