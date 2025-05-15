package com.parkingmanager.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for handling date and time operations
 */
public class DateTimeUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Format a LocalDateTime object to a string
     * 
     * @param dateTime The LocalDateTime to format
     * @return Formatted date-time string
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "N/A";
        }
        return dateTime.format(FORMATTER);
    }
    
    /**
     * Calculate the duration between two LocalDateTime objects
     * 
     * @param start The start time
     * @param end The end time
     * @return A formatted string representing the duration
     */
    public static String formatDuration(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            return "N/A";
        }
        
        Duration duration = Duration.between(start, end);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        
        return String.format("%d hours, %d minutes", hours, minutes);
    }
    
    /**
     * Parse a string to a LocalDateTime object
     * 
     * @param dateTimeStr The string to parse
     * @return The parsed LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, FORMATTER);
    }
    
    /**
     * Calculate the duration in hours (rounded up) between two LocalDateTime objects
     * 
     * @param start The start time
     * @param end The end time
     * @return The duration in hours, rounded up
     */
    public static double calculateHours(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            return 0;
        }
        
        Duration duration = Duration.between(start, end);
        long minutes = duration.toMinutes();
        
        // Round up to the nearest hour
        return Math.ceil(minutes / 60.0);
    }
}
