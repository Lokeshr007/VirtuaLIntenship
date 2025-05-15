package com.parkingmanager.service;

import com.parkingmanager.model.VehicleType;
import com.parkingmanager.util.DateTimeUtil;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Service class to calculate parking fees
 */
public class FeeCalculator {
    // Base rates per hour for different vehicle types
    private static final double CAR_RATE = 2.0;      // $2 per hour
    private static final double MOTORCYCLE_RATE = 1.0; // $1 per hour
    private static final double TRUCK_RATE = 3.0;     // $3 per hour
    private static final double VAN_RATE = 2.5;      // $2.50 per hour
    
    // Minimum fee (for less than 1 hour)
    private static final double MINIMUM_FEE = 1.0;   // $1 minimum fee
    
    /**
     * Calculate the parking fee based on entry and exit times and vehicle type
     * 
     * @param entryTime The time when the vehicle entered
     * @param exitTime The time when the vehicle exited
     * @param vehicleType The type of vehicle
     * @return The calculated parking fee
     */
    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType) {
        // Calculate duration in minutes
        long durationMinutes = Duration.between(entryTime, exitTime).toMinutes();
        
        // Convert to hours, rounding up to the nearest hour
        double durationHours = Math.ceil(durationMinutes / 60.0);
        
        // Special case: if duration is less than 1 hour, apply minimum fee
        if (durationHours < 1) {
            return MINIMUM_FEE;
        }
        
        // Calculate the base rate based on vehicle type
        double hourlyRate = getHourlyRate(vehicleType);
        
        // Calculate the fee
        double fee = durationHours * hourlyRate;
        
        // Apply any discounts or surcharges here if needed
        
        return fee;
    }
    
    /**
     * Get the hourly rate for a specific vehicle type
     * 
     * @param vehicleType The type of vehicle
     * @return The hourly rate
     */
    private double getHourlyRate(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return CAR_RATE;
            case MOTORCYCLE:
                return MOTORCYCLE_RATE;
            case TRUCK:
                return TRUCK_RATE;
            case VAN:
                return VAN_RATE;
            default:
                return CAR_RATE; // Default to car rate
        }
    }
}
