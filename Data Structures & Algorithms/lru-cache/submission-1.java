public class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    int capacity;
    Map <Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //dic for O(1) lookup from key to node
        map = new HashMap<>();
        //dummy head & tail
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);   // move to head
        return node.val;
    }
    
    //update key
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode); //如果有先删掉
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > capacity) {
            ListNode lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }     
    }

    public void add(ListNode node) {
        //node加到头
        node.prev = head;
        node.next = head.next;

        //update
        head.next.prev = node;
        head.next = node;

    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}