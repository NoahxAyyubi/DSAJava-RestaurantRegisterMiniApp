import java.util.ArrayList;

public class Customer {
    private String name; // Customer's name
    private ArrayList<Order> orders; // List to hold customer's orders

    // Constructor to initialize a Customer
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<Order>(); // Initialize the orders list
    }
    
        public String getName() {
            return name;
        }

    // Method to add an order to the customer's order history
    public void addOrder(Order order) {
        orders.add(order); // Add the order to the list
    }

    public ArrayList<Order> getOrders() {
        return orders; // Return the list of orders
    }

    // Method to get customer's details along with their order history
    public String getCustomerDetails() {
        StringBuilder details = new StringBuilder("Customer: " + name + "\nOrders:\n");

        // Iterate over each order and add its details to the string
        for (Order order : orders) {
            details.append(order.getOrderDetails()).append("\n");
        }

        return details.toString(); // Return the complete order history
    }
}