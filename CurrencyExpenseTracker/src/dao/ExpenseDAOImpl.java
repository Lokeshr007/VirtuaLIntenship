package dao;
import model.Expense;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ExpenseDAOImpl {
    private Connection conn;
    public ExpenseDAOImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:db/expenses.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS expenses (id INTEGER PRIMARY KEY AUTOINCREMENT, amount REAL, category TEXT, currency TEXT, date TEXT, description TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addExpense(Expense e) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO expenses(amount, category, currency, date, description) VALUES (?, ?, ?, ?, ?)");
            ps.setDouble(1, e.getAmount());
            ps.setString(2, e.getCategory());
            ps.setString(3, e.getCurrency());
            ps.setString(4, e.getDate());
            ps.setString(5, e.getDescription());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateExpense(Expense e) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE expenses SET amount=?, category=?, currency=?, date=?, description=? WHERE id=?");
            ps.setDouble(1, e.getAmount());
            ps.setString(2, e.getCategory());
            ps.setString(3, e.getCurrency());
            ps.setString(4, e.getDate());
            ps.setString(5, e.getDescription());
            ps.setInt(6, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void deleteExpense(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM expenses WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM expenses");
            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getString("currency"),
                    rs.getString("date"),
                    rs.getString("description")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public Expense getExpenseById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM expenses WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getString("currency"),
                    rs.getString("date"),
                    rs.getString("description")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}