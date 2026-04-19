package cafestoragesystem;

import java.util.*;

class Storage {

    private Queue<FoodItem> queue = new LinkedList<>();
    private final int MAX_CAPACITY = 8;

    public void addFood(FoodItem item) {
        if (queue.size() >= MAX_CAPACITY) {
            System.out.println("Storage is FULL (Max 8 items)");
            return;
        }
        queue.add(item);
        System.out.println("Food added successfully!");
    }

    public void removeFood() {
        if (queue.isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }
        FoodItem removed = queue.poll();
        System.out.println("Removed: " + removed.name);
    }

    public void peekFood() {
        if (queue.isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }
        System.out.println("Next item to remove:");
        queue.peek().display();
    }
}
