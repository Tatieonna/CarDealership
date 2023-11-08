package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    private Dealership dealership;



    public DealershipFileManager(Dealership dealership) {
        this.dealership = dealership;
    }

    public static Dealership getDealership() {
        Dealership dealership = new Dealership("Tati's Cars", "111 Your moms", "516-777-9999");
        try{
            FileInputStream fs = new FileInputStream("src/main/resources/Inventory.csv");
            Scanner scanner = new Scanner(fs);
            scanner.nextLine();

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                String [] dataRow = input.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(dataRow[0]), Integer.parseInt(dataRow[1]), dataRow[2], dataRow[3],dataRow[5], dataRow[4], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));
              dealership.addVehicle(vehicle);

            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Uh oh! Something went wrong! ");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fw = new FileWriter("src/main/resources/Inventory.csv");
            String headerRow= String.format("%s | %s | %s %n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            fw.write(headerRow);

            for (Vehicle vehicle : dealership.getAllVehicles()){
                String row = String.format("%d | %d | %s | %s | %s | %s | %d | %f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getVehicleType(), vehicle.getMileage(),vehicle.getPrice());

                fw.write(row);
            }
            fw.close();
        }
        catch(IOException ex){
            System.out.println("Uh oh! Something went wrong! ");
        }
    }
}

