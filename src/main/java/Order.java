public class Order {
    private String item;    // The name of the item ordered
    private int quantity;   // The number of items ordered
    private boolean isCompleted;
    // Constructor to initialize an Order
    public Order(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.isCompleted = false;
        
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void markAsCompleted() {
        this.isCompleted = true; // Update the flag to true
    }

    // Method to get order details as a string
    public String getOrderDetails() {
        return "Item: " + item + ", Quantity: " + quantity;
    }
}