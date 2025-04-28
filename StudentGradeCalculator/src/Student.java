public class Student {
    private int id;
    private String name;
    private int[] marks;
    private int total;
    private double average;
    private String grade;

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        calculateResults();
    }

    public void calculateResults() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = total / (double) marks.length;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else if (average >= 60) grade = "D";
        else grade = "F";
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int[] getMarks() { return marks; }
    public int getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }
}