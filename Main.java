package cafestoragesystem;

import java.util.Scanner;

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
        }
    }
}
