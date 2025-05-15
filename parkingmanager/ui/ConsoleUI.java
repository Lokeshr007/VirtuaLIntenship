package com.parkingmanager.ui;

import com.parkingmanager.exception.ParkingException;
import com.parkingmanager.model.ParkingSlot;
import com.parkingmanager.model.ParkingTicket;
import com.parkingmanager.model.VehicleType;
import com.parkingmanager.service.ParkingService;
import com.parkingmanager.util.DateTimeUtil;

import java.util.List;
import java.util.Scanner;

/**
 * Console-based user interface for the parking management system
 */
public class ConsoleUI {
    private final ParkingService parkingService;
    private final Scanner scanner;
    private boolean running;
    
    /**
     * Constructs a new ConsoleUI
     * 
     * @param parkingService The parking service to use
     */
    public ConsoleUI(ParkingService parkingService) {
        this.parkingService = parkingService;
        this.scanner = new Scanner(System.in);
        this.running = false;
    }
    
    /**
     * Start the UI and the main application loop
     */
    public void start() {
        running = true;
        showWelcomeMessage();
        
        while (running) {
            showMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            try {
                handleMainMenuChoice(choice);
            } catch (ParkingException e) {
                System.out.println("Error: " + e.getMessage());
                waitForEnter();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                waitForEnter();
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using the Parking Management System. Goodbye!");
    }
    
    /**
     * Display the welcome message
     */
    private void showWelcomeMessage() {
        System.out.println("================================================");
        System.out.println("    Welcome to the Parking Management System    ");
        System.out.println("================================================");
        System.out.println("Total parking capacity: " + parkingService.getTotalCapacity() + " slots");
        System.out.println();
    }
    
    /**
     * Display the main menu options
     */
    private void showMainMenu() {
        System.out.println("\n================================================");
        System.out.println("                  MAIN MENU                     ");
        System.out.println("================================================");
        System.out.println("1. Park a Vehicle");
        System.out.println("2. Remove a Vehicle");
        System.out.println("3. Check Vehicle Status");
        System.out.println("4. View Parking Status");
        System.out.println("5. View Available Slots");
        System.out.println("6. View Occupied Slots");
        System.out.println("7. Calculate Current Fee");
        System.out.println("8. Exit");
        System.out.println("------------------------------------------------");
        System.out.println("Available Slots: " + parkingService.getAvailableCount() + 
                           " | Occupied Slots: " + parkingService.getOccupiedCount());
        System.out.println("================================================");
    }
    
    /**
     * Handle the main menu choice
     * 
     * @param choice The user's choice
     * @throws ParkingException if there is an error related to parking operations
     */
    private void handleMainMenuChoice(int choice) throws ParkingException {
        switch (choice) {
            case 1:
                parkVehicle();
                break;
            case 2:
                removeVehicle();
                break;
            case 3:
                checkVehicleStatus();
                break;
            case 4:
                viewParkingStatus();
                break;
            case 5:
                viewAvailableSlots();
                break;
            case 6:
                viewOccupiedSlots();
                break;
            case 7:
                calculateCurrentFee();
                break;
            case 8:
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    /**
     * Handle the park vehicle operation
     * 
     * @throws ParkingException if there is an error related to parking the vehicle
     */
    private void parkVehicle() throws ParkingException {
        System.out.println("\n=== Park a Vehicle ===");
        
        // Check if there are available slots
        if (parkingService.getAvailableCount() == 0) {
            System.out.println("Sorry, the parking lot is full.");
            waitForEnter();
            return;
        }
        
        // Get license plate
        String licensePlate = getStringInput("Enter license plate number: ");
        
        // Display vehicle types
        System.out.println("\nVehicle Types:");
        VehicleType[] types = VehicleType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].getDisplayName());
        }
        
        // Get vehicle type
        int typeChoice = getIntInput("Select vehicle type (1-" + types.length + "): ");
        while (typeChoice < 1 || typeChoice > types.length) {
            System.out.println("Invalid choice. Please try again.");
            typeChoice = getIntInput("Select vehicle type (1-" + types.length + "): ");
        }
        
        VehicleType selectedType = VehicleType.fromIndex(typeChoice - 1);
        
        // Park the vehicle
        ParkingTicket ticket = parkingService.parkVehicle(licensePlate, selectedType);
        
        // Print the ticket
        System.out.println("\n=== Parking Ticket ===");
        System.out.println(ticket.toString());
        
        waitForEnter();
    }
    
    /**
     * Handle the remove vehicle operation
     * 
     * @throws ParkingException if there is an error related to removing the vehicle
     */
    private void removeVehicle() throws ParkingException {
        System.out.println("\n=== Remove a Vehicle ===");
        
        String licensePlate = getStringInput("Enter license plate number: ");
        
        // Remove the vehicle
        ParkingTicket ticket = parkingService.removeVehicle(licensePlate);
        
        // Print the receipt
        System.out.println("\n=== Parking Receipt ===");
        System.out.println(ticket.toString());
        System.out.println("Duration: " + 
                          DateTimeUtil.formatDuration(ticket.getEntryTime(), ticket.getExitTime()));
        System.out.println("Thank you for using our parking service!");
        
        waitForEnter();
    }
    
    /**
     * Handle the check vehicle status operation
     * 
     * @throws ParkingException if there is an error related to checking the vehicle status
     */
    private void checkVehicleStatus() throws ParkingException {
        System.out.println("\n=== Check Vehicle Status ===");
        
        String licensePlate = getStringInput("Enter license plate number: ");
        
        // Get vehicle information
        ParkingTicket ticket = parkingService.getVehicleInfo(licensePlate);
        
        // Display information
        System.out.println("\n=== Vehicle Information ===");
        System.out.println(ticket.toString());
        System.out.println("Current Duration: " + 
                          DateTimeUtil.formatDuration(ticket.getEntryTime(), ticket.getExitTime() != null ? 
                                                    ticket.getExitTime() : java.time.LocalDateTime.now()));
        
        waitForEnter();
    }
    
    /**
     * Handle the view parking status operation
     */
    private void viewParkingStatus() {
        System.out.println("\n=== Parking Status ===");
        System.out.println("Total Capacity: " + parkingService.getTotalCapacity() + " slots");
        System.out.println("Available Slots: " + parkingService.getAvailableCount() + " slots");
        System.out.println("Occupied Slots: " + parkingService.getOccupiedCount() + " slots");
        
        waitForEnter();
    }
    
    /**
     * Handle the view available slots operation
     */
    private void viewAvailableSlots() {
        System.out.println("\n=== Available Slots ===");
        
        List<ParkingSlot> availableSlots = parkingService.getAvailableSlots();
        if (availableSlots.isEmpty()) {
            System.out.println("No available slots.");
        } else {
            for (ParkingSlot slot : availableSlots) {
                System.out.println(slot.toString());
            }
        }
        
        waitForEnter();
    }
    
    /**
     * Handle the view occupied slots operation
     */
    private void viewOccupiedSlots() {
        System.out.println("\n=== Occupied Slots ===");
        
        List<ParkingSlot> occupiedSlots = parkingService.getOccupiedSlots();
        if (occupiedSlots.isEmpty()) {
            System.out.println("No occupied slots.");
        } else {
            for (ParkingSlot slot : occupiedSlots) {
                System.out.println(slot.toString());
            }
        }
        
        waitForEnter();
    }
    
    /**
     * Handle the calculate current fee operation
     * 
     * @throws ParkingException if there is an error related to calculating the fee
     */
    private void calculateCurrentFee() throws ParkingException {
        System.out.println("\n=== Calculate Current Fee ===");
        
        String licensePlate = getStringInput("Enter license plate number: ");
        
        // Calculate the current fee
        double fee = parkingService.getCurrentFee(licensePlate);
        
        // Get ticket information for display
        ParkingTicket ticket = parkingService.getVehicleInfo(licensePlate);
        
        // Display fee information
        System.out.println("\n=== Fee Information ===");
        System.out.println("Vehicle: " + ticket.getVehicle().getLicensePlate() + 
                          " (" + ticket.getVehicle().getType().getDisplayName() + ")");
        System.out.println("Entry Time: " + DateTimeUtil.formatDateTime(ticket.getEntryTime()));
        System.out.println("Current Time: " + DateTimeUtil.formatDateTime(java.time.LocalDateTime.now()));
        System.out.println("Duration: " + 
                          DateTimeUtil.formatDuration(ticket.getEntryTime(), java.time.LocalDateTime.now()));
        System.out.println("Current Fee: $" + String.format("%.2f", fee));
        
        waitForEnter();
    }
    
    /**
     * Get string input from the user
     * 
     * @param prompt The prompt to display
     * @return The user's input
     */
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    /**
     * Get integer input from the user
     * 
     * @param prompt The prompt to display
     * @return The user's input as an integer
     */
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    /**
     * Wait for the user to press Enter
     */
    private void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
