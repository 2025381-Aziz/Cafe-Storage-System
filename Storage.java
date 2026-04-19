package cafestoragesystem;

import java.util.*;

// This class manages the storage using a Queue (FIFO)
class Storage {

    // Queue is used to store food items
    // FIFO means first item added will be removed first
    private Queue<FoodItem> queue = new LinkedList<>();

    // Maximum number of items allowed in storage
    private final int MAX_CAPACITY = 8;

    // This method adds a new food item to the storage
    public void addFood(FoodItem item) {

        // Check if storage is already full
        if (queue.size() >= MAX_CAPACITY) {
            System.out.println("Storage is FULL (Max 8 items)");
            return;
        }

        // Add item to the queue
        queue.add(item);

        // Confirm that item is added
        System.out.println("Food added successfully!");
    }

    // This method removes a food item from storage
    public void removeFood() {

        // Check if storage is empty
        if (queue.isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }

        // Remove the first item from queue (FIFO)
        FoodItem removed = queue.poll();

        // Show which item was removed
        System.out.println("Removed: " + removed.name);
    }

    // This method shows the next item to be removed
    // It does not remove the item
    public void peekFood() {

        // Check if storage is empty
        if (queue.isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }

        // Show the first item in queue
        System.out.println("Next item to remove:");
        queue.peek().display();
    }

    // This method displays all items in storage
    public void displayAll() {

        // Check if storage is empty
        if (queue.isEmpty()) {
            System.out.println("No items in storage!");
            return;
        }

        // Loop through all items and print details
        System.out.println("\nAll Food Items:");
        for (FoodItem item : queue) {
            item.display();
        }
    }

    // This method searches for a food item by name
    public void searchFood(String name) {

        // Variable to track if item is found
        boolean found = false;

        // Loop through all items in queue
        for (FoodItem item : queue) {

            // Compare names ignoring uppercase/lowercase
            if (item.name.equalsIgnoreCase(name)) {
                item.display();
                found = true;
            }
        }

        // If no item matched
        if (!found) {
            System.out.println("Item not found!");
        }
    }
}
