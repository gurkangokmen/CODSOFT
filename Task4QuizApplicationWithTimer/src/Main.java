import question.Answer;
import question.Question;
import quiz.Quiz;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(10, addQuestions());
        try {quiz.start();}  catch (InterruptedException e) {e.printStackTrace();}
    }

    // 1. Quiz Questions and Options: Store quiz questions along with multiple-choice options and correct answers.
    private static List<Question> addQuestions() {
        Answer answer1 = new Answer("China", true);
        Answer answer2 = new Answer("Japan", false);
        Answer answer3 = new Answer("South Korea", false);
        Answer answer4 = new Answer("Thailand", false);

        Question question1 = new Question("What country is known as the Land of the Rising Sun?", List.of(answer1, answer2, answer3, answer4));

        Answer answer5 = new Answer("Australia", false);
        Answer answer6 = new Answer("New Zealand", false);
        Answer answer7 = new Answer("Fiji", false);
        Answer answer8 = new Answer("Papua New Guinea", true);

        Question question2 = new Question("What country is located on the island of New Guinea?", List.of(answer5, answer6, answer7, answer8));

        Answer answer9 = new Answer("India", false);
        Answer answer10 = new Answer("Pakistan", false);
        Answer answer11 = new Answer("Bangladesh", true);
        Answer answer12 = new Answer("Sri Lanka", false);

        Question question3 = new Question("What country is located east of India?", List.of(answer9, answer10, answer11, answer12));

        return List.of(question1, question2, question3);
    }
}