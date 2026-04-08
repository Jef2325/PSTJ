import java.util.*;

// EntityRecord class
class EntityRecord {
    int enrollmentId;
    String student;
    String course;
    String instructor;
    String startDate;
    int duration;

    // Constructor
    EntityRecord(int enrollmentId, String student, String course,
                 String instructor, String startDate, int duration) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.instructor = instructor;
        this.startDate = startDate;
        this.duration = duration;
    }

    // Display method
    public void display() {
        System.out.println(
            "Enrollment_ID: " + enrollmentId +
            ", Student: " + student +
            ", Course: " + course +
            ", Instructor: " + instructor +
            ", Start Date: " + startDate +
            ", Duration: " + duration + " weeks"
        );
    }
}

// Main class
public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of records

        // List to store records
        ArrayList<EntityRecord> list = new ArrayList<>();

        // Input records
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String student = sc.next();
            String course = sc.next();
            String instructor = sc.next();
            String date = sc.next();
            int duration = sc.nextInt();

            list.add(new EntityRecord(id, student, course, instructor, date, duration));
        }

        // Display records
        for (EntityRecord e : list) {
            e.display();
        }

        sc.close();
    }
}