import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    String getName() {
        return name;
    }

    LocalDate getDate() {
        return date;
    }
}

public class task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        // 1. Sort events chronologically
        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());

        sortedEvents.forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();

        // 2. Earliest event
        Event earliest = Collections.min(events, Comparator.comparing(Event::getDate));
        System.out.println(earliest.getName());

        // 3. Latest event
        Event latest = Collections.max(events, Comparator.comparing(Event::getDate));
        System.out.println(latest.getName());

        // 4. Events in given month
        events.stream()
                .filter(e -> e.getDate().getMonthValue() == month)
                .forEach(e -> System.out.print(e.getName() + " "));
    }
}
