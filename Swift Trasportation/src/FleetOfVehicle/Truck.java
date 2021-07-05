package FleetOfVehicle;

public class Truck extends Vehicle{
    protected int capacity;

    public Truck(String value, String make, String model, int year, int mileage, String licensePlate, String fuelType, int capacity) {
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
        String toprint = super.Print();
        toprint += "Capacity : " + this.capacity + "\n";

        return toprint;
    }

}
