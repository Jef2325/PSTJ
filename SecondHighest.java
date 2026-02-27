import java.util.*;

public class SecondHighest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = list.stream()
                .distinct()                      
                .sorted(Collections.reverseOrder()) 
                .skip(1)                       
                .findFirst()                     
                .orElse(-1);                     

        System.out.println(result);
        sc.close();
    }
}
