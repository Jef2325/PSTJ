import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail

        head.next = tail;
        tail.prev = head;
    }

    // GET operation
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    // PUT operation
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }

    // Move node to front (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Add node right after head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Remove least recently used node
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}

// -------------------- DRIVER CODE --------------------
public class task8 {
    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // cache: {1=1}
        lRUCache.put(2, 2); // cache: {1=1, 2=2}

        System.out.println(lRUCache.get(1)); // 1

        lRUCache.put(3, 3); // evicts key 2

        System.out.println(lRUCache.get(2)); // -1

        lRUCache.put(4, 4); // evicts key 1

        System.out.println(lRUCache.get(1)); // -1
        System.out.println(lRUCache.get(3)); // 3
        System.out.println(lRUCache.get(4)); // 4
    }
}