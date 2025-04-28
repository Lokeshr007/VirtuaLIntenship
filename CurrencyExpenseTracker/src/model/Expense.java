package model;
public class Expense {
    private int id;
    private double amount;
    private String category;
    private String currency;
    private String date;
    private String description;
    public Expense(int id, double amount, String category, String currency, String date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.currency = currency;
        this.date = date;
        this.description = description;
    }
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getCurrency() { return currency; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
}