import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random rand = new Random();
            boolean playAgain = true;
            int score = 0;
            int round = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            
            while (playAgain) {
                int target = rand.nextInt(100) + 1; 
                int maxAttempts = 7;
                int attempts = 0;
                boolean guessedCorrectly = false;
                round++;
                
                System.out.println("\nRound " + round + ": I'm thinking of a number between 1 and 100.");
                System.out.println("You have " + maxAttempts + " attempts. Good luck!");
                
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = input.nextInt();
                    attempts++;
                    
                    if (guess == target) {
                        System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                        score += (maxAttempts - attempts + 1); 
                        guessedCorrectly = true;
                        break;
                    } else if (guess < target) {
                        System.out.println("low.");
                    } else {
                        System.out.println("high.");
                    }
                    
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
                
                if (!guessedCorrectly) {
                    System.out.println("You've used all your attempts. The number was: " + target);
                }
                
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = input.next().toLowerCase();
                playAgain = response.equals("yes");
            }
            
            System.out.println("\nGame Over! You played " + round + " round(s).");
            System.out.println("Final Score: " + score);
        }
    }
}
