import java.util.Scanner;

/**
 * Exercise 6: Simple Calculator
 * PT821 - Object-Oriented Programming
 *
 * TASK:
 * Create a calculator program that:
 * 1. Asks the user for two numbers
 * 2. Asks for an operation (+, -, *, /)
 * 3. Performs the calculation and displays the result
 * 4. Handles division by zero
 *
 * CONCEPTS PRACTICED:
 * - Variables and data types
 * - Scanner for input
 * - switch-case statement
 * - Arithmetic operators
 */
public class Exercise6_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===\n");

        // Get first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Get second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Get operation
        System.out.print("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result;
        boolean validOperation = true;

        // Perform calculation using switch
        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, result);
                break;
            case '-':
                result = num1 - num2;
                System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, result);
                break;
            case '*':
                result = num1 * num2;
                System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, result);
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Error: Invalid operation!");
                validOperation = false;
        }

        scanner.close();
    }
}

/*
 * SAMPLE OUTPUT:
 * =============
 *
 * === Simple Calculator ===
 *
 * Enter first number: 15
 * Enter second number: 4
 * Enter operation (+, -, *, /): *
 * 15.00 * 4.00 = 60.00
 *
 * EXTENSION CHALLENGE:
 * - Add modulus (%) operation
 * - Add power (^) operation using Math.pow()
 * - Allow multiple calculations in a loop until user quits
 */
