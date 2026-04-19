package cafestoragesystem;

class FoodItem {

    String name;
    double weight;
    String bestBefore;
    String timeAdded;

    public FoodItem(String name, double weight, String bestBefore, String timeAdded) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeAdded = timeAdded;
    }
}
