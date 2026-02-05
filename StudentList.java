
/**
 * Write a description of class Studentlist here.
 *
 * @author (Abdulrahim 24bia069)
 * @version (5 feb 2025)
 */
import java.util.ArrayList;
import java.util.Scanner;
public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        int choice;

        System.out.println("Student List Manager");

        do {
            System.out.println("Menu");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. View all students");
            System.out.println("4. Search for a student");
            System.out.println("5. Count total students");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                    System.out.print("Enter student name: ");
                    String nameToAdd = scanner.nextLine();
                    students.add(nameToAdd);
                    System.out.println(" " + nametoAdd + " added successfully!");
                    break;

                    if (students.isEmpty()) {
                        System.out.println("No students to remove!");
                    } else {
                        System.out.print("Enter student name to remove: ");
                        String nametoRemove = scanner.nextLine();
                        if (students.remove(nameToRemove)) {
                            System.out.println(" " + nametoRemove + " removed successfully!");
                        } else {
                            System.out.println(" Student not found!");
                        }
                    }
                    break;

                
                    if (students.isempty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("Student List");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    if (students.contains(searchName)) {
                        int index = students.indexOf(searchName);
                        System.out.println(" found! " + searchName + " is at position " + (index + 1));
                    } else {
                        System.out.println(" student not found!");
                    }
                    break;

                    System.out.println("Total students: " + students.size());
                    break;
                    
                    System.out.println("\nThank you for using Studentlist Manager!");
                    System.out.println("bye");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}