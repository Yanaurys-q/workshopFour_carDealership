package com.ps;

import java.io.*;

public class DealershipFileManager {
    public static Dealership getDealership() {
        Dealership dealership = null;
        try {BufferedReader bufferedReader = new BufferedReader(new FileReader("Inventory.csv"));

            String input = bufferedReader.readLine();

            if (input == null || input.isBlank())
            {
                System.out.println("Empty or missing dealership header line.");
                return null;
            }

            String[] dealershipDetails = input.split("\\|");
            if (dealershipDetails.length < 3)
            {
                System.out.println("Invalid dealership header format.");
                return null;
            }

            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];

            dealership = new Dealership(name, address, phone);

            while ((input = bufferedReader.readLine()) != null) {
                String[] vehicleDetails = input.split("\\|");
                if (vehicleDetails.length < 8)
                {
                    System.out.println("Skipping invalid vehicle entry: " + input);
                    continue;
                }

                try {
                    String vin = vehicleDetails[0];
                    int year = Integer.parseInt(vehicleDetails[1]);
                    String make = vehicleDetails[2];
                    String model = vehicleDetails[3];
                    String type = vehicleDetails[4];
                    String color = vehicleDetails[5];
                    int odometer = Integer.parseInt(vehicleDetails[6]);
                    double price = Double.parseDouble(vehicleDetails[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    dealership.addVehicle(vehicle);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing vehicle data: " + input);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found");
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Inventory.csv"));
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
            for (Vehicle v : dealership.getAllVehicles()) {
                bw.write(v.toCSV());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving dealership: " + e.getMessage());
        }
    }
}
