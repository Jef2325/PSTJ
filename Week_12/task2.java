import java.util.*;

class Item {
    String name;
    double rating;

    Item(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }
}

public class task2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Item> list = new ArrayList<>();

        // Input
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double rating = sc.nextDouble();
            list.add(new Item(name, rating));
        }

        double threshold = 8.0;

        // Filter
        ArrayList<Item> filtered = new ArrayList<>();

        for (Item item : list) {
            if (item.rating >= threshold) {
                filtered.add(item);
            }
        }

        // Sort (Lambda version)
        filtered.sort((a, b) -> {
            if (a.rating != b.rating) {
                return Double.compare(b.rating, a.rating); // descending rating
            }
            return a.name.compareTo(b.name); // ascending name
        });

        // Output
        for (Item item : filtered) {
            System.out.println(item.name + " " + item.rating);
        }
    }
}