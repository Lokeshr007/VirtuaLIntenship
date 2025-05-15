package com.parkingmanager.exception;

/**
 * Custom exception class for parking-related errors
 */
public class ParkingException extends Exception {
    /**
     * Constructs a new parking exception with the specified detail message
     * 
     * @param message The detail message
     */
    public ParkingException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new parking exception with the specified detail message and cause
     * 
     * @param message The detail message
     * @param cause The cause
     */
    public ParkingException(String message, Throwable cause) {
        super(message, cause);
    }
}
