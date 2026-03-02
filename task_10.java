import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'circularPalindromes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING s as parameter.
     */

    public static List<Integer> circularPalindromes(String s) {
    // Write your code here
     List<Integer> result = new ArrayList<>();
    int n = s.length();
    
    for (int i = 0; i < n; i++) {
        // Rotate string
        String rotated = s.substring(i) + s.substring(0, i);
        
        // Find longest palindrome in rotated string
        result.add(longestPalindrome(rotated));
    }
    
    return result;
}

private static int longestPalindrome(String s) {
    int maxLen = 1;
    
    for (int i = 0; i < s.length(); i++) {
        // Odd length
        maxLen = Math.max(maxLen, expand(s, i, i));
        
        // Even length
        maxLen = Math.max(maxLen, expand(s, i, i + 1));
    }
    
    return maxLen;
}

private static int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() 
            && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;

    }

}

public class task_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
