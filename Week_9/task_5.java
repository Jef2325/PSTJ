import java.util.*;

// Custom Exception
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

// Order Class
class Order {
    int orderId;
    String productName;
    int quantity;
    int availableStock;

    Order(int orderId, String productName, int quantity, int availableStock) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }

    // Method to process order
    void processOrder() throws InsufficientStockException {
        if (quantity > availableStock) {
            throw new InsufficientStockException("Insufficient stock");
        }
    }
}

// Main Class
public class task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String product = sc.next();
            int qty = sc.nextInt();
            int stock = sc.nextInt();

            Order order = new Order(id, product, qty, stock);

            try {
                order.processOrder();
                System.out.println("Order " + id + " processed successfully");
            } catch (InsufficientStockException e) {
                System.out.println("Order " + id + " failed: " + e.getMessage());
            }
        }

        sc.close();
    }
}