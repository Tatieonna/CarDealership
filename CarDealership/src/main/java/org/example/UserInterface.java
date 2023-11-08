package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.printf("Welcome to %s, the best place to buy a car! %n", this.dealership.getName());
            System.out.printf("Located at %s %n", this.dealership.getAddress());
            System.out.println("Select from the following options");
            System.out.println("1: View all vehicles");
            System.out.println("2: Search for vehicles by price");
            System.out.println("3: Search for vehicles by make/ model");
            System.out.println("4: Search for vehicles by year ");
            System.out.println("5: Search for vehicles by color");
            System.out.println("6: Search for vehicles by mileage ");
            System.out.println("7: Search for vehicles by Vehicle Type");
            System.out.println("8: Add a vehicle");
            System.out.println("9: Remove a vehicle");
            System.out.println("0: Exit");

            try {
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        processGetAllVehiclesRequest();
                        break;
                    case 2:
                        processGetByPriceRequest();
                        break;
                    case 3:
                        processGetByMakeModelRequest();
                        break;
                    case 4:
                        processGetByYearRequest();
                        break;
                    case 5:
                        processGetByColorRequest();
                        break;
                    case 6:
                        processGetByMileageRequest();
                        break;
                    case 7:
                        processGetByVehicleTypeRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 0:
                        DealershipFileManager.saveDealership(dealership);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choose from out existing options ");
                        break;

                }
            } catch (InputMismatchException ex) {
                System.out.println("Please select one of the provided numbers! ");
                scanner.nextLine();
            }
        }
        scanner.close();

        public void processGetByPriceRequest () {
            boolean isGettingByPrice = true;

            while (isGettingByPrice) {
                try {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Please enter minimum price ");
                    double minPrice = scanner2.nextDouble();
                    System.out.println("Please enter maximum price ");
                    double maxPrice = scanner2.nextDouble();

                    if (minPrice < maxPrice) {
                        System.out.printf("Here are all the vehicles in your price range of %d and %d", minPrice, maxPrice);
                        List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                        displayVehicles(vehicleList);
                        isGettingByPrice = false;
                    } else {
                        System.out.println("Minimum price can't be greater than maximum price! ");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Must be a number! ");
                }
            }
        }

        public void processGetByMakeModelRequest() {
            boolean isGettingByMakeModel = true;

            while (isGettingByMakeModel) {
                try {
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Enter the make of the vehicle ");
                    String make = scanner3.nextLine();
                    System.out.println("Enter the model of the vehicle ");
                    String model = scanner3.nextLine();

                    List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                    displayVehicles(vehicleList);
                    isGettingByMakeModel = false;
                } catch (InputMismatchException ex) {
                    System.out.println("Sorry, try again ");
                }
            }
        }

        public void processGetByYearRequest() {
            boolean isGettingByYear = true;

            while (isGettingByYear) {
                try {
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Enter the minimum year ");
                    int minYear = scanner4.nextInt();
                    System.out.println("Enter the maximum year ");
                    int maxYear = scanner4.nextInt();

                    if (minYear <= maxYear) {
                        List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                        displayVehicles(vehicleList);
                        isGettingByYear = false;
                    } else {
                        System.out.println("Minimum year can't be greater than maximum year ");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Oops, please enter a valid number ");
                }
            }
        }

        public void processGetByColorRequest() {
            boolean isGettingByColor = true;

            while (isGettingByColor) {
                try {
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Enter a vehicle color ");
                    String color = scanner5.nextLine();

                    List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
                    displayVehicles(vehicleList);
                    isGettingByColor = false;
                } catch (InputMismatchException ex) {
                    System.out.println("Oops, please enter a color ");
                }
            }
        }


        public void processGetByMileageRequest() {
            boolean isGettingByMileage = true;

            while (isGettingByMileage) {
                try {
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Enter the minimum mileage");
                    int minMileage = scanner6.nextInt();
                    System.out.println("Enter the maximum mileage ");
                    int maxMileage = scanner6.nextInt();

                    if (minMileage <= maxMileage) {
                        List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
                        displayVehicles(vehicleList);
                        isGettingByMileage = false;
                    } else {
                        System.out.println("Minimum mileage cant be greater than maximum mileage");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please put a number...");
                }

            }

            public void processGetByVehicleTypeRequest() {
                boolean isGettingByVehicleType = true;

                while (isGettingByVehicleType) {
                    try {
                        Scanner scanner7 = new Scanner(System.in);
                        System.out.println("Enter the vehicle type ");
                        String vehicleType = scanner7.nextLine();

                        List<Vehicle> vehicleList = dealership.getVehiclesByVehicleType(vehicleType);
                        displayVehicles(vehicleList);
                        isGettingByVehicleType = false;
                    } catch (InputMismatchException ex) {
                        System.out.println("Sorry, try again");
                    }
                }
            }

            public void processGetAllVehiclesRequest () {
                displayVehicles(this.dealership.getAllVehicles());
            }

            public void processAddVehicleRequest() {
                boolean isAddingVehicle = true;

                while (isAddingVehicle) {
                    try {
                        Scanner scanner8 = new Scanner(System.in);
                        System.out.println("Enter VIN ");
                        int vin = scanner8.nextInt();
                        scanner8.nextLine();

                        System.out.println("Enter Year ");
                        int year = scanner8.nextInt();
                        scanner8.nextLine();

                        System.out.println("Enter make ");
                        String make = scanner8.nextLine();

                        System.out.println("Enter model ");
                        String model = scanner8.nextLine();

                        System.out.println("Enter color");
                        String color = scanner8.nextLine();

                        System.out.println("Enter vehicle type ");
                        String vehicleType = scanner8.nextLine();

                        System.out.println("Enter mileage");
                        int mileage = scanner8.nextInt();
                        scanner8.nextLine();

                        System.out.println("Enter price");
                        double price = scanner8.nextDouble();

                        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);

                        dealership.addVehicle(newVehicle);

                        System.out.println("Vehicle added! ");
                        isAddingVehicle = false;
                    } catch (InputMismatchException ex) {
                        System.out.println("Sorry, please try again ");
                    }
                }
            }

            public void processRemoveVehicleRequest () {
                boolean isRemovingVehicle = true;

                while (isRemovingVehicle) {
                    try {
                        Scanner scanner9 = new Scanner(System.in);
                        System.out.println("Enter the VIN of the vehicle you want to remove ");
                        int vinToRemove = scanner9.nextInt();
                        scanner9.nextLine();

                        List<Vehicle> inventory = dealership.getAllVehicles();
                        Vehicle vehicleToRemove = null;

                        for (Vehicle vehicle : inventory) {
                            if (vehicle.getVin() == vinToRemove) {
                                vehicleToRemove = vehicle;
                                break;
                            }
                        }
                        if (vehicleToRemove != null) {
                            dealership.removeVehicle(vehicleToRemove);
                            System.out.println("Vehicle removed! ");
                        } else {
                            System.out.println("Vehicle with VIN" + vinToRemove + "not found");
                        }
                        isRemovingVehicle = false;
                    } catch (InputMismatchException ex) {
                        System.out.println("Try again: VIN must be a number");
                    }
                }
            }

            private void displayVehicles (List < Vehicle > vehicles) {
                for (Vehicle vehicle : displayVehicles) {
                    System.out.println(vehicle.toString());
                }

            }
        }
    }
}

