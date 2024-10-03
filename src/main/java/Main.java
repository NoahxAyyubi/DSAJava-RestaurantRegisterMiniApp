import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>(); // List to store customers

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Order for Customer");
            System.out.println("3. Display Customer Order History");
            System.out.println("4. Mark an Order as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Add a new customer
                    System.out.print("\nEnter customer name: ");
                    String customerName = scanner.nextLine();
                    customers.add(new Customer(customerName)); // Add the customer directly to the list
                    System.out.println("Customer " + customerName + " added!");
                    break;

                case "2":
                    // Add an order for a customer
                    System.out.print("Enter customer name to add an order: ");
                    String orderCustomerName = scanner.nextLine();
                    Customer orderCustomer = findCustomer(customers, orderCustomerName);
                    if (orderCustomer != null) {
                        System.out.print("Enter order item: ");
                        String item = scanner.nextLine();

                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        Order order = new Order(item, quantity);
                        orderCustomer.addOrder(order); // Add the order to the existing customer's order history
                        System.out.println("Order for " + item + " added to " + orderCustomerName + "'s orders!");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case "3":
                    // Display order history for a customer
                    System.out.print("Enter customer name to view order history: ");
                    String nameToView = scanner.nextLine();
                    Customer foundCustomer = findCustomer(customers, nameToView);
                    if (foundCustomer != null) {
                        System.out.println("\nOrder History for " + foundCustomer.getName() + ":");
                        System.out.println(foundCustomer.getCustomerDetails());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case "4":
                    // Mark an order as completed
                    System.out.print("Enter customer name to mark an order as completed: ");
                    String completeCustomerName = scanner.nextLine();
                    Customer completeCustomer = findCustomer(customers, completeCustomerName);
                    if (completeCustomer != null) {
                        System.out.println("Order History for " + completeCustomer.getName() + ":");
                        System.out.println(completeCustomer.getCustomerDetails());

                        System.out.print("Enter the index of the order you wish to mark as completed: ");
                        int orderIndex = Integer.parseInt(scanner.nextLine());

                        if (orderIndex >= 0 && orderIndex < completeCustomer.getOrders().size()) {
                            completeCustomer.getOrders().get(orderIndex).markAsCompleted(); // Mark the order as completed
                            System.out.println("Order marked as completed!");
                        } else {
                            System.out.println("Invalid order index.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to find a customer by name
    private static Customer findCustomer(ArrayList<Customer> customers, String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c; // Return the found customer
            }
        }
        return null; // Return null if not found
    }
}