import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Connection conn;

    public StudentDAOImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:db/students.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, marks TEXT, total INTEGER, average REAL, grade TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name, marks, total, average, grade) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, student.getName());
            ps.setString(2, marksToString(student.getMarks()));
            ps.setInt(3, student.getTotal());
            ps.setDouble(4, student.getAverage());
            ps.setString(5, student.getGrade());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, marks=?, total=?, average=?, grade=? WHERE id=?");
            ps.setString(1, student.getName());
            ps.setString(2, marksToString(student.getMarks()));
            ps.setInt(3, student.getTotal());
            ps.setDouble(4, student.getAverage());
            ps.setString(5, student.getGrade());
            ps.setInt(6, student.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    stringToMarks(rs.getString("marks"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    stringToMarks(rs.getString("marks"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String marksToString(int[] marks) {
        StringBuilder sb = new StringBuilder();
        for (int mark : marks) {
            sb.append(mark).append(",");
        }
        return sb.toString();
    }

    private int[] stringToMarks(String marksStr) {
        String[] parts = marksStr.split(",");
        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            marks[i] = Integer.parseInt(parts[i]);
        }
        return marks;
    }
}