package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);


    public UserInterface() {
        init();
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
        if (dealership == null) {
            System.out.println("No dealership data found.");
        }
    }

    public void display() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Car Dealership Menu ---");
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Sell/Lease a vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processSellOrLeaseVehicleRequest();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Command not found, try again");
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("\nVIN | Year | Make | Model | Type | Color | Odometer | Price");
            for (Vehicle v : vehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetByYearRequest() {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getYear() == year) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getColor().equalsIgnoreCase(color)) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetByMileageRequest() {
        System.out.print("Enter maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getOdometer() <= maxMileage) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getType().equalsIgnoreCase(type)) {
                result.add(v);
            }
        }
        displayVehicles(result);
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle v = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(v);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle added!");
    }


    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        String vin = scanner.nextLine();
        boolean removed = dealership.removeVehicle(vin);
        if (removed) {
            DealershipFileManager.saveDealership(dealership);
            System.out.println("Vehicle removed!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void processSellOrLeaseVehicleRequest() {
        System.out.print("Enter VIN of vehicle to sell/lease: ");
        String vin = scanner.nextLine();
        Vehicle vehicle = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin().equalsIgnoreCase(vin)) {
                vehicle = v;
                break;
            }
        }
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter contract date (YYYYMMDD): ");
        String date = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Is this a sale or lease? (Enter 'sale' or 'lease'): ");
        String contractType = scanner.nextLine().trim().toLowerCase();

        Contract contract = null;

        if (contractType.equals("sale")) {
            System.out.print("Will the customer finance the vehicle? (yes/no): ");
            boolean isFinanced = scanner.nextLine().trim().equalsIgnoreCase("yes");
            contract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
        } else if (contractType.equals("lease")) {
            int currentYear = java.time.LocalDate.now().getYear();
            if (currentYear - vehicle.getYear() > 3) {
                System.out.println("Cannot lease a vehicle over 3 years old.");
                return;
            }
            contract = new LeaseContract(date, customerName, customerEmail, vehicle);
        } else {
            System.out.println("Invalid contract type.");
            return;
        }

        ContractFileManager.saveContract(contract);
        dealership.removeVehicle(vin);
        DealershipFileManager.saveDealership(dealership);

        System.out.println("Contract processed and vehicle removed from inventory.");
        System.out.println("Total Price: $" + contract.getTotalPrice());
        System.out.println("Monthly Payment: $" + contract.getMonthlyPayment());
    }
}



