import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Grade> grades;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }
}