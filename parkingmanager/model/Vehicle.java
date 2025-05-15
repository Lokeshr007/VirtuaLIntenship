package com.parkingmanager.model;

/**
 * Represents a vehicle that can park in the parking lot
 */
public class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    /**
     * Constructs a new Vehicle object
     * 
     * @param licensePlate The vehicle's license plate number
     * @param type The type of vehicle
     */
    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    /**
     * Get the license plate number of the vehicle
     * 
     * @return The license plate number
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Get the type of the vehicle
     * 
     * @return The vehicle type
     */
    public VehicleType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return licensePlate.equals(vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return licensePlate.hashCode();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                '}';
    }
}
