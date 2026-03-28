import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class student_sort{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            students.add(new Student(name, marks));
        }

        int K = sc.nextInt();

        String result = students.stream()
                .sorted(
                        Comparator.comparingInt((Student s) -> s.marks)
                                .reversed()
                                .thenComparing(s -> s.name)
                )
                .limit(K)
                .map(s -> s.name)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}