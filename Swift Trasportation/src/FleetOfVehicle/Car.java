package FleetOfVehicle;

public class Car extends Vehicle {
    protected double endine;

    public Car(String value, String make, String model, int year, int mileage, String licensePlate, String fuelType, double endine) {
        super(make, model, year, mileage, licensePlate, fuelType);
        this.endine = endine;
    }

    public double getEndine() {
        return endine;
    }
    public String setEndine(String endine) {
        return endine;
    }



    public String Print(){
        return ("Make: " + getMake() + " Model: " + getModel() + " Year: " + getYear() + " Mileage: " + getMileage() +
                " License Plate: " + getLicensePlate() + " Fuel Type: " + getFuelType() + " Endine: " + this.getEndine());
    }
}
