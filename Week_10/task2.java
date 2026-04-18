import java.util.*;
import java.io.*;

class task2 {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        // Step 1: Create HashMap
        Map<String, Integer> map = new HashMap<>();

        // Step 2: Store entries
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            map.put(name, phone);
        }

        // Step 3: Process queries
        while (in.hasNext()) {
            String s = in.nextLine();

            if (map.containsKey(s)) {
                System.out.println(s + "=" + map.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}