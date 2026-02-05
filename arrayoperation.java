
/**
 * Write a description of class arrayoperation here.
 *
 * @author (Abdulrahim 24bia069)
 * @version (5 feb 2026)
 */
 class arrayoperation{
     import java.util.Scanner;
public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Array Operations ===\n");

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Your Numbers ---");
        System.out.print(" ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.length;

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }

        System.out.println("\n--- Statistics ---");
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        scanner.close();
    }
}
 }

   