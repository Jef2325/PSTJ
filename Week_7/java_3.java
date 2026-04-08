import java.util.*;

class UndergroundSystem {

    private Map<Integer, CheckIn> checkInMap;
    
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        checkInMap.remove(id);
        
        String key = checkIn.station + "-" + stationName;
        int travelTime = t - checkIn.time;
        
        Route route = routeMap.getOrDefault(key, new Route(0, 0));
        route.totalTime += travelTime;
        route.count += 1;
        
        routeMap.put(key, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Route route = routeMap.get(key);
        return (double) route.totalTime / route.count;
    }
    
    class CheckIn {
        String station;
        int time;
        
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    
    class Route {
        int totalTime;
        int count;
        
        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}