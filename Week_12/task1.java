import java.util.*;

public class task1 {

    public static int minMeetingRooms(int[][] meetings) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: mark start and end times
        for (int[] m : meetings) {
            int start = m[0];
            int end = m[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int rooms = 0;
        int maxRooms = 0;

        // Step 2: sweep line
        for (int val : map.values()) {
            rooms += val;
            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        System.out.println(minMeetingRooms(meetings));
    }
}