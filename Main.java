package cafestoragesystem;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    // Main method where program starts
    public static void main(String[] args) {

        // Scanner is used to read user input from keyboard
        Scanner sc = new Scanner(System.in);

        // Create storage object (this uses Queue inside)
        Storage storage = new Storage();

        // Infinite loop to keep program running until user exits
        while (true) {

            // Show menu options
            System.out.println("\n==== CAFE STORAGE MENU ====");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek (View Next)");
            System.out.println("4. Display All");
            System.out.println("5. Search Food");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice;

            // Try to read menu input safely
            // If user types something wrong, program will not crash
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // go back to menu
            }

            // Handle user choice
            switch (choice) {

                case 1:
                    // ===== ADD FOOD =====

                    // Ask for food name
                    System.out.print("Enter food name: ");
                    String name = sc.nextLine();

                    // Validate weight input (must be number)
                    double weight = 0;
                    while (true) {
                        System.out.print("Enter weight (grams): ");
                        try {
                            weight = Double.parseDouble(sc.nextLine());

                            // Check if weight is positive
                            if (weight <= 0) {
                                System.out.println("Weight must be greater than zero.");
                                continue;
                            }

                            break; // valid input, exit loop

                        } catch (Exception e) {
                            // If user enters text instead of number
                            System.out.println("Invalid input. Enter numbers only.");
                        }
                    }

                    // Validate date input using LocalDate
                    String date;
                    while (true) {
                        System.out.print("Enter best before date (YYYY-MM-DD): ");
                        date = sc.nextLine();

                        try {
                            // Try to convert string to date
                            LocalDate parsedDate = LocalDate.parse(date);

                            // Get today's date
                            LocalDate today = LocalDate.now();

                            // Maximum allowed date is 14 days from today
                            LocalDate maxDate = today.plusDays(14);

                            // Check if date is in the past
                            if (parsedDate.isBefore(today)) {
                                System.out.println("Date cannot be in the past.");
                            }
                            // Check if date is too far in future
                            else if (parsedDate.isAfter(maxDate)) {
                                System.out.println("Date must be within 2 weeks.");
                            }
                            else {
                                break; // valid date
                            }

                        } catch (DateTimeParseException e) {
                            // If format is wrong
                            System.out.println("Invalid format. Use YYYY-MM-DD.");
                        }
                    }

                    // Get current time automatically
                    String time = java.time.LocalTime.now().toString();

                    // Create new FoodItem object
                    FoodItem item = new FoodItem(name, (int) weight, date, time);

                    // Add item to storage
                    storage.addFood(item);
                    break;

                case 2:
                    // ===== REMOVE FOOD =====
                    storage.removeFood();
                    break;

                case 3:
                    // ===== PEEK =====
                    // Show next item without removing it
                    storage.peekFood();
                    break;

                case 4:
                    // ===== DISPLAY ALL =====
                    storage.displayAll();
                    break;

                case 5:
                    // ===== SEARCH =====
                    System.out.print("Enter food name to search: ");
                    String search = sc.nextLine();
                    storage.searchFood(search);
                    break;

                case 6:
                    // ===== EXIT PROGRAM =====
                    System.out.println("Program closed.");
                    return;

                default:
                    // If user enters wrong menu number
                    System.out.println("Invalid choice.");
            }
        }
    }
}
