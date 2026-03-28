import java.util.*;

class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   // number of test cases
        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int mid = n / 2;

            String left = s.substring(0, mid);
            String right;

            if (n % 2 == 0) {
                right = s.substring(mid);
            } else {
                right = s.substring(mid + 1);
            }

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (char c : left.toCharArray()) {
                freq1[c - 'a']++;
            }

            for (char c : right.toCharArray()) {
                freq2[c - 'a']++;
            }

            if (Arrays.equals(freq1, freq2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
