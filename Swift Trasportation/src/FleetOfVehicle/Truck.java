package FleetOfVehicle;

public class Truck extends Vehicle{
    protected int capacity;

    public Truck(String make, String model, int year, double mileage, String licensePlate, String fuelType, int capacity) {
        super(make, model, year, mileage, licensePlate, fuelType);
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int setCapacity(int capacity){
        return capacity;
    }

    public String Print(){
        return ("Make: " + getMake() + " Model: " + getModel() + " Year: " + getYear() + " Mileage: " + getMileage() +
                " License Plate: " + getLicensePlate() + " Fuel Type: " + getFuelType() + " Passenger: " + this.getCapacity());
    }

}
