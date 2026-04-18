import java.util.*;

class Movie {
    String name;
    String genre;
    double rating;

    Movie(String name, String genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }
}

class User {
    String name;
    List<Movie> watchHistory;

    User(String name, List<Movie> watchHistory) {
        this.name = name;
        this.watchHistory = watchHistory;
    }
}

class RecommendationEngine {

    public List<Movie> getRecommendations(User user) {

        List<Movie> recommendations = new ArrayList<>();

        // Dummy recommendation logic (for simplicity)
        for (int i = 1; i <= 5; i++) {
            recommendations.add(new Movie("RecommendedMovie" + i, "Genre" + i, 8.5));
        }

        return recommendations;
    }
}

public class task3 {

    public static void main(String[] args) {

        RecommendationEngine engine = new RecommendationEngine();

        // 🔹 Test 1: No watch history
        User user1 = new User("user1", new ArrayList<>());
        test(engine, user1, "No Watch History");

        // 🔹 Test 2: One movie watched
        List<Movie> history2 = new ArrayList<>();
        history2.add(new Movie("Inception", "SciFi", 9.0));
        User user2 = new User("user2", history2);
        test(engine, user2, "Single Watch History");

        // 🔹 Test 3: Multiple same ratings
        List<Movie> history3 = Arrays.asList(
                new Movie("A", "Action", 8.0),
                new Movie("B", "Drama", 8.0),
                new Movie("C", "Comedy", 8.0)
        );
        User user3 = new User("user3", new ArrayList<>(history3));
        test(engine, user3, "Same Ratings");

        // 🔹 Test 4: Large history (stress test)
        List<Movie> history4 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            history4.add(new Movie("Movie" + i, "Genre" + (i % 5), 7.0));
        }
        User user4 = new User("user4", history4);
        test(engine, user4, "Stress Test");
    }

    public static void test(RecommendationEngine engine, User user, String testName) {

        List<Movie> result = engine.getRecommendations(user);

        System.out.println("Test: " + testName);

        if (result != null && result.size() >= 5) {
            System.out.println("PASS → Recommendations: " + result.size());
        } else {
            System.out.println("FAIL");
        }

        System.out.println("------------------------");
    }
}