import java.util.*;

public class task9 {

    public static int colorful(int A) {

        String num = String.valueOf(A);
        Set<Integer> set = new HashSet<>();

        int n = num.length();

        // generate all contiguous subsequences
        for (int i = 0; i < n; i++) {

            int product = 1;

            for (int j = i; j < n; j++) {

                int digit = num.charAt(j) - '0';
                product *= digit;

                // if product already exists → not colorful
                if (set.contains(product)) {
                    return 0;
                }

                set.add(product);
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        int A = 23;
        System.out.println(colorful(A)); // Output: 1
    }
}