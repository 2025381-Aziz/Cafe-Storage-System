package cafestoragesystem;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();

        while (true) {

            System.out.println("\n==== CAFE STORAGE MENU ====");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek (View Next)");
            System.out.println("4. Display All");
            System.out.println("5. Search Food");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {

    case 1:

        System.out.print("Enter food name: ");
        String name = sc.nextLine();

        double weight = 0;
        while (true) {
            System.out.print("Enter weight (grams): ");
            try {
                weight = Double.parseDouble(sc.nextLine());
                if (weight <= 0) {
                    System.out.println("Weight must be greater than zero.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter numbers only.");
            }
        }

        String date;
        while (true) {
            System.out.print("Enter best before date (YYYY-MM-DD): ");
            date = sc.nextLine();

            try {
                LocalDate parsedDate = LocalDate.parse(date);
                LocalDate today = LocalDate.now();
                LocalDate maxDate = today.plusDays(14);

                if (parsedDate.isBefore(today)) {
                    System.out.println("Date cannot be in the past.");
                } else if (parsedDate.isAfter(maxDate)) {
                    System.out.println("Date must be within 2 weeks.");
                } else {
                    break;
                }

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use YYYY-MM-DD.");
            }
        }

        String time = java.time.LocalTime.now().toString();

        FoodItem item = new FoodItem(name, (int) weight, date, time);
        storage.addFood(item);
        break;
                    case 2:
    storage.removeFood();
    break;

case 3:
    storage.peekFood();
    break;
        }
    }
}
