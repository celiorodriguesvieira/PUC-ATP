package FleetOfVehicle;

import java.util.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SwiftTransportation {

    public static void main(String[] args) {
        var bus = new ArrayList<Bus>();
        var car = new ArrayList<Car>();
        var truck = new ArrayList<Truck>();

        bus.add(new Bus("Marcopolo","Paradiso", 2021, 14.000, "BXX04978", "Diesel",18));
        car.add(new Car("Dodge", "Durango", 2021, 0, "DOOD7898", "Diesel", 2.0));
        truck.add(new Truck("Kenworth", "T680", 2020, 100, "KENW0982", "Diesel", 50000));

        for (var newbus: bus){
            System.out.println(newbus.Print());
        }

        for (var newcar: car) {
            System.out.println(newcar.Print());
        }

        for (var newtruck: truck) {
            System.out.println(newtruck.Print());
        }


    }

}
