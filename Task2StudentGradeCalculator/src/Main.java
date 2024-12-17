import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject.
        for (Subject subject : Subject.values()) {
            int score;
            do {
                System.out.println("Enter the score for " + subject + " (0-100): ");
                score = scanner.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Please enter a value between 0 and 100.");
                }
            } while (score < 0 || score > 100);
            student.addGrade(new Grade(subject, score));
        }

        // Calculate Total Marks: Sum up the marks obtained in all subjects.
        int totalMarks = 0;
        for (Grade grade : student.getGrades()) {
            totalMarks += grade.getScore();
        }

        // Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average percentage.
        double averagePercentage = totalMarks / (double) student.getGrades().size();

        // Grade Calculation: Assign grades based on the average percentage achieved.
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}