import java.util.Random;
import java.util.Scanner;

public class Task2 {  // Ensure this class name matches the filename: Task2.java
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of Rounds: 3");
        System.out.println("Attempts To Guess Number In Each Round: 10\n");

        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;
            int guess_number = 0;  // Move the variable declaration outside the loop

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                guess_number = scanner.nextInt();
                attempts++;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts;
                    totalScore += score;
                    System.out.printf("Hurray! Number guessed successfully. Attempts = %d. Round Score = %d\n", attempts, score);
                    break;
                } else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts left = %d.\n", guess_number, MAX_ATTEMPTS - attempts);
                } else {
                    System.out.printf("The number is less than %d. Attempts left = %d.\n", guess_number, MAX_ATTEMPTS - attempts);
                }
            }

            if (attempts == MAX_ATTEMPTS && guess_number != number) {
                System.out.printf("\nRound %d: You've used all attempts.\n", i);
                System.out.printf("The Random Number was: %d\n\n", number);
            }

            // Display total score after each round
            System.out.printf("Total Score After Round %d: %d\n\n", i, totalScore);
        }

        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}