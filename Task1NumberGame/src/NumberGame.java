import java.util.Scanner;

public class NumberGame {
    // 5. Limit the number of attempts the user has to guess the number.
    private int attempts = 5;
    private int attempt = 1;
    private int score = 100;
    private  Number number;

    public NumberGame() {
        number = new Number();
    }

    public void play(){
        System.out.println("Number Game🔢");

        number.generateRandomNumber();
        int generatedNumber = number.getRandomNumber();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 100: ");

        int userNumber;

        // 2. Prompt the user to enter their guess for the generated number.
        // 3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
        // 4. Repeat steps 2 and 3 until the user guesses the correct number.

        while (attempt <= attempts) {
            userNumber = scanner.nextInt();

            if (userNumber == generatedNumber) {
                System.out.println("Congratulations! You guessed the number!");
                break;
            }
            else if (userNumber > generatedNumber) { if (attempt!=5){System.out.println("The number is smaller than " + userNumber);} score -= 20;}
            else if(userNumber < generatedNumber) {if (attempt!=5){System.out.println("The number is greater than " + userNumber);} score -= 20;}


            attempt++;
        }

        // 7. Display the user's score, which can be based on the number of attempts taken or rounds won.
        if (attempt > attempts) {
            System.out.println("You have run out of attempts. The number was " + generatedNumber);
            System.out.println("Your score is: " + score);

            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = scanner.next();

            if (playAgain.equals("yes")) { NumberGame numberGame = new NumberGame(); numberGame.play();}
            else if(playAgain.equals("no")) {System.out.println("Thank you for playing!");}
            else{ System.out.println("Thank you for playing!");}
        }

        else {
            System.out.println("Your score is: " + score);

            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = scanner.next();
            if (playAgain.equals("yes")) { NumberGame numberGame = new NumberGame(); numberGame.play();}
            else if(playAgain.equals("no")) {System.out.println("Thank you for playing!");}
            else{ System.out.println("Thank you for playing!");}
        }

    }
}
