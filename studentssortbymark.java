import java.util.*;
import java.util.stream.*;

public class studentssortbymark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        List<String[]> students =
                IntStream.range(0, N)
                         .mapToObj(i -> sc.nextLine().split(" "))
                         .collect(Collectors.toList());

        int K = Integer.parseInt(sc.nextLine());

        String result =
                students.stream()
                        .sorted(
                            Comparator
                                .comparingInt((String[] s) -> Integer.parseInt(s[1]))
                                .reversed()
                                .thenComparing(s -> s[0])
                        )
                        .limit(K)
                        .map(s -> s[0])
                        .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
