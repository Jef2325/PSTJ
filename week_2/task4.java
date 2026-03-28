import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    static boolean isOlderThan(Person p, int ageLimit) {
        return p.age > ageLimit;
    }
}

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        persons.stream()
                .map(Person::getName)
                .sorted(String::compareTo)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        persons.stream()
                .filter(p -> Person.isOlderThan(p, ageLimit))
                .map(Person::getName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
        persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));
    }
}
