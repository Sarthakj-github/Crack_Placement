class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        flat_dll(head);
        return head;
    }

    private Node flat_dll(Node head) {
        Node curr = head;
        Node tail = head;
        
        while (curr != null) {
            Node next = curr.next;
            
            if (curr.child != null) {
                Node childTail = flat_dll(curr.child);
                
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                
                tail = childTail;
            } else {
                tail = curr;
            }
            
            curr = next;
        }
        
        return tail;
    }
}
