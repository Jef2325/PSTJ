import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter value of K: ");
        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println("Invalid K value");
            return;
        }
        Arrays.sort(arr);
        System.out.println("The " + k + "th smallest element is: " + arr[k - 1]);
    }
}
