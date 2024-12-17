import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject.
        for (Subject subject : Subject.values()) {
            System.out.println("Enter the score for " + subject + ": ");
            int score = scanner.nextInt();
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