import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundNumber = 1;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\n--- Round " + roundNumber + " ---");
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 5;
            int roundScore = 0;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.println("Guess a number between 1 and 100 (Attempts left: " + attemptsLeft + "): ");
                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number within the range 1 to 100.");
                    continue;
                }

                attemptsLeft--;

                if (guess == numberToGuess) {
                    roundScore = attemptsLeft + 1; // Score is based on remaining attempts
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the correct number " + numberToGuess + ".");
                    System.out.println("Round score: " + roundScore);
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Total score: " + totalScore);
            System.out.print("Would you like to play another round? (yes/no): ");

            String playAgainInput = scanner.next().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            roundNumber++;
        }

        System.out.println("\nThank you for playing the Number Guessing Game!");
        System.out.println("Your final score is: " + totalScore);

        scanner.close();
    }
}
