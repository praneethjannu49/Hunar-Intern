import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;  // Lower bound of the number range
        int upperBound = 100;  // Upper bound of the number range
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;  // Generate random number

        int maxAttempts = 10;  // Maximum number of attempts allowed
        int attempts = 0;  // Initialize the number of attempts taken

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        boolean hasGuessedCorrectly = false; 

        while (attempts < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + "): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try guessing higher.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try guessing lower.");
            } else {
                hasGuessedCorrectly = true;
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you did not guess the number. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
