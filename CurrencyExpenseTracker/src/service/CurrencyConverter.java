package service;
import java.util.HashMap;
import java.util.Map;
public class CurrencyConverter {
    private static final Map<String, Double> conversionRates = new HashMap<>();
    static {
        conversionRates.put("USD", 1.0);
        conversionRates.put("INR", 83.0);
        conversionRates.put("EUR", 0.92);
    }
    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = conversionRates.get(fromCurrency.toUpperCase());
        double toRate = conversionRates.get(toCurrency.toUpperCase());
        return (amount / fromRate) * toRate;
    }
}