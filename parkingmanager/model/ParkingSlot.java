package com.parkingmanager.model;

/**
 * Represents a single parking slot in the parking lot
 */
public class ParkingSlot {
    private final int slotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    /**
     * Constructs a new parking slot
     * 
     * @param slotNumber The number of this slot in the parking lot
     */
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.occupied = false;
        this.vehicle = null;
    }

    /**
     * Get the slot number
     * 
     * @return The slot number
     */
    public int getSlotNumber() {
        return slotNumber;
    }

    /**
     * Check if the slot is occupied
     * 
     * @return true if the slot is occupied, false otherwise
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Get the vehicle parked in this slot
     * 
     * @return The vehicle, or null if no vehicle is parked
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Park a vehicle in this slot
     * 
     * @param vehicle The vehicle to park
     * @return true if the vehicle was parked successfully, false if the slot was already occupied
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if (!occupied) {
            this.vehicle = vehicle;
            this.occupied = true;
            return true;
        }
        return false;
    }

    /**
     * Remove the vehicle from this slot
     * 
     * @return The vehicle that was removed, or null if no vehicle was parked
     */
    public Vehicle removeVehicle() {
        if (occupied) {
            Vehicle removedVehicle = this.vehicle;
            this.vehicle = null;
            this.occupied = false;
            return removedVehicle;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Slot #" + slotNumber + (occupied ? " (Occupied by " + vehicle.getLicensePlate() + ")" : " (Available)");
    }
}
