package FleetOfVehicle;

public class Bus extends Vehicle{
    protected int passenger;

    public Bus(String value, String make, String model, int year, int mileage, String licensePlate, String fuelType, int passenger) {
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
       String toprint = super.Print();
       toprint += "Passeger: " + this.passenger + "\n";
       return toprint;
   }

}
