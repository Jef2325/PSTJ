import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        String period = s.substring(s.length() - 2); 
        String time = s.substring(0, 8);             

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d:%s:%s", hour, parts[1], parts[2]);
    }
}

public class task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
