import java.util.*;

class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int vehicleId, String modelName, double baseRent) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.baseRent = baseRent;
    }
    double calculateRent() {
        return baseRent;
    }

    void display() {
        System.out.println("Vehicle ID: " + vehicleId +
                ", Model: " + modelName +
                ", Total Rent: " + calculateRent());
    }
}

class Car extends Vehicle {
    int seats;

    Car(int vehicleId, String modelName, double baseRent, int seats) {
        super(vehicleId, modelName, baseRent);
        this.seats = seats;
    }

    @Override
    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

class Bike extends Vehicle {
    int engineCapacity;

    Bike(int vehicleId, String modelName, double baseRent, int engineCapacity) {
        super(vehicleId, modelName, baseRent);
        this.engineCapacity = engineCapacity;
    }

    @Override
    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);

            int id = sc.nextInt();
            String model = sc.next();
            double baseRent = sc.nextDouble();

            if (type == 'C') {
                int seats = sc.nextInt();
                vehicles.add(new Car(id, model, baseRent, seats));
            } else if (type == 'B') {
                int engine = sc.nextInt();
                vehicles.add(new Bike(id, model, baseRent, engine));
            }
        }

        for (Vehicle v : vehicles) {
            v.display();
        }

        sc.close();
    }
}