class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode (int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        ListNode node = map.get(key);
        remove(node);
        add(node);   // move to head
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
        }

        map.put(key, new ListNode(key, value));
        add(map.get(key));

        if (map.size() > capacity) {
            ListNode lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void add (ListNode node) {
        //add to the head
        ListNode temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }

    private void remove (ListNode node) {
        // 1 -> 2 -> 3
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }
}
