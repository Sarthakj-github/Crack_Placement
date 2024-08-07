class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }
        
        greater.next = null;
        less.next = greaterHead.next; 

        return lessHead.next; 
    }
}
