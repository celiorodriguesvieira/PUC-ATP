package FleetOfVehicle;
import java.io.Serializable;

public abstract  class Vehicle  implements Serializable {
    protected String make;
    protected String model;
    protected int year;
    protected int mileage;
    protected String licensePlate;
    protected String fuelType;

public Vehicle (String make,String model, int year, int mileage, String licensePlate, String fuelType) {
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

    public int getMileage(){
        return mileage;
    }

    public int setMileage(int Mileage) {
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
     String toprint = "";

     toprint += "Make: " + this.make + "\n";
     toprint += "Model: " + this.model + "\n";
     toprint += "Year: " + this.year + "\n";
     toprint += "Mileage: " + this.mileage + "\n";
     toprint += "License Plate: " + this.licensePlate + "\n";
     toprint += "Fuel Type: " + this.fuelType + "\n";

     return toprint;
    }
}
