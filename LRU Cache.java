class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addNode(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int ans = resNode.val;
            deleteNode(resNode);
            addNode(resNode);
            map.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            deleteNode(curr);
        } else if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, head.next);
    }
}
