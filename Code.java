import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, String> currencySymbols = new HashMap<>();
    static {
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("INR", "₹");
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: USD, EUR, GBP, INR");
        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        if (!currencySymbols.containsKey(baseCurrency) || !currencySymbols.containsKey(targetCurrency)) {
            System.out.println("Invalid currency code entered. Please try again.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        double convertedAmount = convertCurrency(amount, exchangeRate);

        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, currencySymbols.get(targetCurrency));

        scanner.close();
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        // Mock exchange rates for demonstration purposes
        Map<String, Double> mockRates = new HashMap<>();
        mockRates.put("USD_TO_EUR", 0.85);
        mockRates.put("USD_TO_GBP", 0.75);
        mockRates.put("USD_TO_INR", 74.0);
        mockRates.put("EUR_TO_USD", 1.18);
        mockRates.put("GBP_TO_USD", 1.33);
        mockRates.put("INR_TO_USD", 0.013);

        String key = baseCurrency + "_TO_" + targetCurrency;
        return mockRates.getOrDefault(key, 1.0);
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
