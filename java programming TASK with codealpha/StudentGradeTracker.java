import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> scores;

    public Student(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addScore(double score) {
        scores.add(score);
    }

    public double getAverage() {
        if (scores.isEmpty()) return 0;
        double sum = 0;
        for (double s : scores) {
            sum += s;
        }
        return sum / scores.size();
    }

    public double getHighest() {
        if (scores.isEmpty()) return 0;
        double max = scores.get(0);
        for (double s : scores) {
            if (s > max) max = s;
        }
        return max;
    }

    public double getLowest() {
        if (scores.isEmpty()) return 0;
        double min = scores.get(0);
        for (double s : scores) {
            if (s < min) min = s;
        }
        return min;
    }

    public ArrayList<Double> getScores() {
        return scores;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        // Input number of students
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            Student student = new Student(name);

            System.out.print("Enter number of scores for " + name + ": ");
            int numScores = scanner.nextInt();

            for (int j = 0; j < numScores; j++) {
                System.out.print("Enter score " + (j + 1) + ": ");
                double score = scanner.nextDouble();
                student.addScore(score);
            }

            students.add(student);
            scanner.nextLine();  // consume newline
        }

        // Display summary report
        System.out.println("\n=== Summary Report ===");
        for (Student s : students) {
            System.out.println("Student: " + s.getName());
            System.out.println("Scores: " + s.getScores());
            System.out.printf("Average: %.2f\n", s.getAverage());
            System.out.printf("Highest: %.2f\n", s.getHighest());
            System.out.printf("Lowest: %.2f\n", s.getLowest());
            System.out.println();
        }

        scanner.close();
    }
}
