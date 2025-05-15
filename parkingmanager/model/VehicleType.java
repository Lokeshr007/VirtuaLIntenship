package com.parkingmanager.model;

/**
 * Enum representing the different types of vehicles
 */
public enum VehicleType {
    CAR("Car"),
    MOTORCYCLE("Motorcycle"),
    TRUCK("Truck"),
    VAN("Van");

    private final String displayName;

    /**
     * Constructs a new VehicleType enum
     * 
     * @param displayName The display name for this vehicle type
     */
    VehicleType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the display name for this vehicle type
     * 
     * @return The display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Get a VehicleType enum by its ordinal index
     * 
     * @param index The ordinal index
     * @return The corresponding VehicleType
     */
    public static VehicleType fromIndex(int index) {
        return VehicleType.values()[index];
    }
}
