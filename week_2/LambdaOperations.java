import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class LambdaOperations {

    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n, reverse = 0;
            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n /= 10;
            }
            return original == reverse;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int choice = sc.nextInt();
            int num = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(isOdd().check(num) ? "ODD" : "EVEN");
                    break;
                case 2:
                    System.out.println(isPrime().check(num) ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    System.out.println(isPalindrome().check(num) ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
        }
        sc.close();
    }
}
