package FleetOfVehicle;

import java.util.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class SwiftTransportation {
    private ArrayList <Vehicle> vehicles;

    public SwiftTransportation(){
        this.vehicles = new ArrayList<Vehicle>();
    }

    public String [] readData(String [] dataInput) {
        String [] dataOut = new String[dataInput.length];

        for (int i = 0; i < dataInput.length; i++)
            dataOut[i] = JOptionPane.showInputDialog("Enter the following data: " + dataInput[i]+ ": ");
        return dataOut;
    }

    public Truck readTruck(){
        String [] values = new String[6];
        String [] namevalues = {"Make", "Model", "Year", "Mileage", "License Plate", "Fuel Type","Capacity (tonne)"};
        values = readData(namevalues);

        String make = this.convertString(values[0]);
        String model= this.convertString(values[1]);
        int year = this.convertInteger(values[2]);
        int mileage = this.convertInteger(values[3]);
        String licensePlate = this.convertString(values[4]);
        String fuelType = this.convertString(values[5]);
        int capacity = this.convertInteger(values[6]);

        Truck truck = new Truck(values[0],make,model,year,mileage,licensePlate,fuelType,capacity);
        return truck;
    }

    public Bus readBus(){
        String [] values = new String [6];
        String [] namevalues = {"Make", "Model", "Year", "Mileage (mi)", "License Plate", "Fuel Type"," Number of Passenger"};
        values = readData(namevalues);
        String make = this.convertString(values[0]);
        String model= this.convertString(values[1]);
        int year = this.convertInteger(values[2]);
        int mileage = this.convertInteger(values[3]);
        String licensePlate = this.convertString(values[4]);
        String fuelType = this.convertString(values[5]);
        int passenger = this.convertInteger(values[6]);

        Bus bus = new Bus(values[0],make, model,year,mileage,licensePlate,fuelType,passenger);
        return bus;
    }

    public Car readCar(){
        String [] values = new String[6];
        String [] namevalues = {"Make", "Model", "Year", "Mileage", "License Plate", "Fuel Type","Engine"};
        values = readData(namevalues);
        String make = this.convertString(values[0]);
        String model= this.convertString(values[1]);
        int year = this.convertInteger(values[2]);
        int mileage = this.convertInteger(values[3]);
        String licensePlate = this.convertString(values[4]);
        String fuelType = this.convertString(values[5]);
        double engine = this.convertDouble(values[6]);

        Car car = new Car(values[0],make, model,year,mileage,licensePlate,fuelType,engine);
        return car;
    }

    private boolean intValid(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public int convertInteger(String enter){
        int numberInt;
        while (!this.intValid(enter)){
            enter = JOptionPane.showInputDialog(null, "[Error] number invalid!\n\n Enter the new number.");
        }
        return  Integer.parseInt(enter);
    }

    private boolean doubleValid(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }

    private double convertDouble(String enter){
        float numFloat;

        while (!this.doubleValid(enter)){
            enter = JOptionPane.showInputDialog(null, "[Error] number enter with new number.");
        }
        return Double.parseDouble(enter);
    }

    public void estoqueVehivles(ArrayList<Vehicle>vehicles){
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("vehicle.data"));
            for (int i = 0; i < vehicles.size(); i++)
                outputStream.writeObject(vehicles);

        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"{Error] Unable to create file!");
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                if (outputStream !=null){
                    outputStream.flush();
                    outputStream.close();
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("finally")
    public ArrayList<Vehicle> recoverVehicle(){
        ArrayList<Vehicle> vehiclesMemori = new ArrayList<Vehicle>();

        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("vehicle.data"));
            Object object = null;
            while ((object = inputStream.readObject()) != null){
                if(object instanceof Vehicle) {
                    vehiclesMemori.add((Vehicle) object);
                }
            }
        }catch (EOFException ex){
            System.out.println("End file!");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File Vehicle don't exist!");
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
            }catch (final  IOException ex){
                ex.printStackTrace();
            }
            return vehiclesMemori;
        }
    }

    public void menuVehicle (){
        String menu = "";
        String enter;
        int opt1, opt2;

        do {

            menu = "Control Swift Transport \n\n" +
                    "Options: \n" +
                    "1. Enter Vehicle\n" +
                    "2. Show Vehicle\n" +
                    "3. Clear Vehicle\n" +
                    "4. Save Vehicle\n" +
                    "5. Backup Vehicle\n" +
                    "9. Exit Vehicle\n";
            enter = JOptionPane.showInputDialog(menu + "\n\n");
            opt1 = this.convertInteger(enter);

            switch (opt1) {
                case 1:
                    menu = "Enter the Vehicles \n" +
                            "Options:\n" +
                            "1.Truck\n" +
                            "2.Bus\n" +
                            "3.Car\n" ;
                    enter = JOptionPane.showInputDialog(menu + "\n\n");
                    opt2 = this.convertInteger(enter);
                switch (opt2){
                    case 1: vehicles.add((Vehicle) readTruck());
                    break;
                    case 2: vehicles.add((Vehicle) readBus());
                    break;
                    case 3: vehicles.add((Vehicle) readCar());
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "You didn't choose Vehicle!");
                }
                break;

                case 2:

                    if (vehicles.size() == 0){
                        JOptionPane.showMessageDialog(null,"You didn't register vehicle! Back to create.");
                        break;
                    } String data = "";
                    for (int i = 0 ; i < vehicles.size(); i++) {
                        data += vehicles.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null, data);
                    break;

                case 3:
                    if (vehicles.size() == 0){
                        JOptionPane.showMessageDialog(null,"Don't there data to clean!");
                        break;
                    }
                    vehicles.clear();
                    JOptionPane.showMessageDialog(null, "Data clear!");
                    break;
                case 4:
                    if (vehicles.size() == 0){
                        JOptionPane.showMessageDialog(null,"There is no data to save.");
                        break;
                    }
                    saveVehicles(vehicles);
                    JOptionPane.showMessageDialog(null,"Data saved successfully!");
                    break;

               case 5: vehicles = recoverVehicle();
                if (vehicles.size() == 0){
                    JOptionPane.showMessageDialog(null,"There is no data to save.");
                    break;
                }
                JOptionPane.showMessageDialog(null, "Data recover sucessffuly.");
                break;

                case 9:
                    JOptionPane.showMessageDialog(null,"End System!");
                    break;
                }
        }while (opt1 != 9);
    }

    public static void main(String[] args) {
        SwiftTransportation transport = new SwiftTransportation();

        transport.menuVehicle();

    }

    private String convertString(String value){
        return value;
    }

    private void saveVehicles(ArrayList<Vehicle> vehicles){
        System.out.println(vehicles.toString());
    }

}
