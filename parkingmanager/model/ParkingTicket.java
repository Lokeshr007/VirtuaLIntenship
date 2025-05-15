package com.parkingmanager.model;

import java.time.LocalDateTime;

/**
 * Represents a parking ticket issued when a vehicle enters the parking lot
 */
public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final int slotNumber;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fee;
    
    /**
     * Constructs a new parking ticket
     * 
     * @param vehicle The vehicle for which the ticket is issued
     * @param slotNumber The slot number assigned to the vehicle
     */
    public ParkingTicket(Vehicle vehicle, int slotNumber) {
        this.ticketId = generateTicketId(vehicle.getLicensePlate());
        this.vehicle = vehicle;
        this.slotNumber = slotNumber;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
        this.fee = 0.0;
    }
    
    /**
     * Generate a unique ticket ID based on license plate and current time
     * 
     * @param licensePlate The vehicle's license plate
     * @return A unique ticket ID
     */
    private String generateTicketId(String licensePlate) {
        return licensePlate + "-" + System.currentTimeMillis();
    }
    
    /**
     * Get the ticket ID
     * 
     * @return The ticket ID
     */
    public String getTicketId() {
        return ticketId;
    }
    
    /**
     * Get the vehicle associated with this ticket
     * 
     * @return The vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    /**
     * Get the slot number assigned to the vehicle
     * 
     * @return The slot number
     */
    public int getSlotNumber() {
        return slotNumber;
    }
    
    /**
     * Get the entry time of the vehicle
     * 
     * @return The entry time
     */
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    /**
     * Get the exit time of the vehicle
     * 
     * @return The exit time, or null if the vehicle has not exited yet
     */
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    
    /**
     * Set the exit time of the vehicle
     * 
     * @param exitTime The exit time
     */
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
    
    /**
     * Get the parking fee
     * 
     * @return The parking fee
     */
    public double getFee() {
        return fee;
    }
    
    /**
     * Set the parking fee
     * 
     * @param fee The parking fee
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * Check if the ticket has been closed (vehicle exited)
     * 
     * @return true if the vehicle has exited, false otherwise
     */
    public boolean isClosed() {
        return exitTime != null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket ID: ").append(ticketId).append("\n");
        sb.append("Vehicle: ").append(vehicle.getLicensePlate()).append(" (").append(vehicle.getType()).append(")\n");
        sb.append("Slot Number: ").append(slotNumber).append("\n");
        sb.append("Entry Time: ").append(entryTime).append("\n");
        
        if (exitTime != null) {
            sb.append("Exit Time: ").append(exitTime).append("\n");
            sb.append("Parking Fee: $").append(String.format("%.2f", fee)).append("\n");
        } else {
            sb.append("Status: Active (Vehicle still parked)\n");
        }
        
        return sb.toString();
    }
}
