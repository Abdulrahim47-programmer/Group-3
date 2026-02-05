
/**
 * Write a description of class NumberGuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Number Guessing Game ===\n");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it!\n");

        int secretNumber = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        while (guess != secretNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
        }
            if (guess < secretNumber) {
                System.out.println("Too low! Try again.\n");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.\n");
            } else {
                System.out.println("\n Congratulations!");
                System.out.println("You guessed it in " + attempts + " attempts!");
                
                if (attempts <= 5) {
                    System.out.println("Rating: Excellent! You're a mind reader!");
                } else if (attempts <= 10) {
                    System.out.println("Rating: Good job!");
                } else {
                    System.out.println("Rating: You got it eventually!");
                }
            }
            scanner.close();
    }
}    
    
