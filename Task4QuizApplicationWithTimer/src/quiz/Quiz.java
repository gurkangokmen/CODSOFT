package quiz;

import question.Answer;
import question.Question;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int seconds ;

    public Quiz(int seconds, List<Question> questions) {
        seconds = seconds;
        this.questions = questions;
    }

    public void start() throws InterruptedException {
       startQuiz();
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.size()) {
            final boolean[] inputReceived = {false};

            // Thread to wait for user input
            Thread inputThread = new Thread(() -> {
                displayQuestions();
                System.out.println("Enter your answer: ");

                synchronized (scanner) {
                    if (scanner.hasNextLine()) {
                        inputReceived[0] = true;
                        String answer = scanner.nextLine();
                        checkAnswer(answer);
                    }
                }
            });

            inputThread.start();

            try {inputThread.join(10000);} catch (InterruptedException e) {System.out.println("Thread interrupted.");}

            if (!inputReceived[0]) {System.out.println("\nTime's up! You didn't enter anything."); inputThread.interrupt();}
            currentQuestionIndex++;
            System.out.println("Proceeding to the next question...\n");
        }

        System.out.println("Your score is: " + score);
        System.exit(0);
    }

    public void displayQuestions() {
        System.out.println(questions.get(currentQuestionIndex).getQuestion());
        for (Answer answer : questions.get(currentQuestionIndex).getAnswers()) {
            System.out.println(answer.getAnswer());
        }
    }

    public void checkAnswer(String answer) {
        if (questions.get(currentQuestionIndex).getAnswers().stream().anyMatch(a -> a.getAnswer().equals(answer) && a.isCorrect())) {
            score++;
        }
    }
}