import java.util.*;

// Interface
interface Notification {
    void sendNotification(String message);
}

// Email Implementation
class EmailNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

// SMS Implementation
class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

// Push Implementation
class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

// Main Class
public class task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            String message = sc.next();

            Notification notification;

            if (type == 'E') {
                notification = new EmailNotification();
            } else if (type == 'S') {
                notification = new SMSNotification();
            } else {
                notification = new PushNotification();
            }

            // Polymorphic call
            notification.sendNotification(message);
        }

        sc.close();
    }
}