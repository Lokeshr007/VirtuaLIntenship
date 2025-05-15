package com.parkingmanager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a parking lot with multiple parking slots
 */
public class ParkingLot {
    private final List<ParkingSlot> slots;
    private final Map<String, ParkingTicket> activeTickets;
    
    /**
     * Constructs a new parking lot with the specified number of slots
     * 
     * @param capacity The number of parking slots in the lot
     */
    public ParkingLot(int capacity) {
        slots = new ArrayList<>(capacity);
        for (int i = 1; i <= capacity; i++) {
            slots.add(new ParkingSlot(i));
        }
        activeTickets = new HashMap<>();
    }
    
    /**
     * Get all parking slots
     * 
     * @return List of all parking slots
     */
    public List<ParkingSlot> getAllSlots() {
        return new ArrayList<>(slots);
    }
    
    /**
     * Get all available parking slots
     * 
     * @return List of available parking slots
     */
    public List<ParkingSlot> getAvailableSlots() {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }
    
    /**
     * Get all occupied parking slots
     * 
     * @return List of occupied parking slots
     */
    public List<ParkingSlot> getOccupiedSlots() {
        List<ParkingSlot> occupiedSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied()) {
                occupiedSlots.add(slot);
            }
        }
        return occupiedSlots;
    }
    
    /**
     * Find a slot by its number
     * 
     * @param slotNumber The slot number to find
     * @return The slot, or null if not found
     */
    public ParkingSlot findSlot(int slotNumber) {
        for (ParkingSlot slot : slots) {
            if (slot.getSlotNumber() == slotNumber) {
                return slot;
            }
        }
        return null;
    }
    
    /**
     * Find a slot containing a vehicle with the given license plate
     * 
     * @param licensePlate The license plate to search for
     * @return The slot containing the vehicle, or null if not found
     */
    public ParkingSlot findSlotByLicensePlate(String licensePlate) {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() && slot.getVehicle().getLicensePlate().equals(licensePlate)) {
                return slot;
            }
        }
        return null;
    }
    
    /**
     * Add a ticket to the active tickets
     * 
     * @param ticket The ticket to add
     */
    public void addTicket(ParkingTicket ticket) {
        activeTickets.put(ticket.getVehicle().getLicensePlate(), ticket);
    }
    
    /**
     * Get a ticket by license plate
     * 
     * @param licensePlate The license plate to look up
     * @return The ticket, or null if not found
     */
    public ParkingTicket getTicket(String licensePlate) {
        return activeTickets.get(licensePlate);
    }
    
    /**
     * Remove a ticket from active tickets
     * 
     * @param licensePlate The license plate of the vehicle whose ticket to remove
     * @return The removed ticket, or null if not found
     */
    public ParkingTicket removeTicket(String licensePlate) {
        return activeTickets.remove(licensePlate);
    }
    
    /**
     * Get the total capacity of the parking lot
     * 
     * @return The total number of slots
     */
    public int getCapacity() {
        return slots.size();
    }
    
    /**
     * Get the number of available slots
     * 
     * @return The number of available slots
     */
    public int getAvailableCount() {
        return getAvailableSlots().size();
    }
    
    /**
     * Get the number of occupied slots
     * 
     * @return The number of occupied slots
     */
    public int getOccupiedCount() {
        return getOccupiedSlots().size();
    }
}
