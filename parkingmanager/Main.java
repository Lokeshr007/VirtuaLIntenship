package com.parkingmanager;

import com.parkingmanager.model.ParkingLot;
import com.parkingmanager.service.ParkingService;
import com.parkingmanager.ui.ConsoleUI;

/**
 * Main entry point for the Parking Management System
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Parking Management System...");
        
        // Initialize the parking lot with 10 slots
        ParkingLot parkingLot = new ParkingLot(10);
        
        // Initialize the parking service
        ParkingService parkingService = new ParkingService(parkingLot);
        
        // Initialize the UI and start the application
        ConsoleUI ui = new ConsoleUI(parkingService);
        ui.start();
    }
}
