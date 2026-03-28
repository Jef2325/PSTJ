import java.util.*;

public class MiniMaxSum {

    static void miniMaxSum(int[] arr) {
        long totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        for (int num : arr) {
            long currentSum = totalSum - num;
            minSum = Math.min(minSum, currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        miniMaxSum(arr);
        sc.close();
    }
}
