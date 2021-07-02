package FleetOfVehicle;
import java.io.Serializable;

public abstract  class Vehicle  implements Serializable {
    protected String make;
    protected String model;
    protected int year;
    protected double mileage;
    protected String licensePlate;
    protected String fuelType;

public Vehicle (String make,String model, int year, double mileage, String licensePlate, String fuelType) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.licensePlate = licensePlate;
    this.fuelType = fuelType;

}

    public String getMake() {
        return make;
    }

    public String setMake(String make) {
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }
    public int setYear(int year) {
        return year;
    }

    public double getMileage(){
        return mileage;
    }

    public double setMileage(double Mileage) {
        return Mileage;
    }

    public String getLicensePlate(){
        return licensePlate;
    }
    public String setLicensePlate( String licensePlate){
        return licensePlate;
    }

    public String getFuelType() {
        return fuelType;
    }
    public String setFuelType(String fuelType){
        return fuelType;
    }

    public String Print(){
        return ("Make: " + getMake() + " Model: " + getModel() + " Year: " + getYear() + " Mileage: " + getMileage() +
                " License Plate: " + getLicensePlate() + " Fuel Type: " + getFuelType());
    }
}
