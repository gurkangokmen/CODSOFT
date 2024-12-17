import java.util.Random;

public class Number {
    private int randomNumber;
    private Random random;

    public Number() { random = new Random();}

    // 1. Generate a random number within a specified range, such as 1 to 100.
    public void generateRandomNumber() {
        randomNumber = random.nextInt(101);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
