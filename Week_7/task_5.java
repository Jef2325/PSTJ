import java.util.*;

class BrowserHistory {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String current;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        current = homepage;
    }
    
    public void visit(String url) {
        backStack.push(current);   
        current = url;           
        forwardStack.clear();      
    }
    
    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
            steps--;
        }
        return current;
    }
}