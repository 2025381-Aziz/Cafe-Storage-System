package cafestoragesystem;

// This class represents a single food item in the storage
class FoodItem {

    // Name of the food (e.g. Burger, Pizza)
    String name;

    // Weight of the food in grams
    double weight;

    // Best before date in format YYYY-MM-DD
    String bestBefore;

    // Time when the item was added to storage
    String timeAdded;

    // Constructor is used to create a new FoodItem object
    public FoodItem(String name, double weight, String bestBefore, String timeAdded) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeAdded = timeAdded;
    }

    // This method prints all details of the food item
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Best Before: " + bestBefore);
        System.out.println("Time Added: " + timeAdded);
    }
}
