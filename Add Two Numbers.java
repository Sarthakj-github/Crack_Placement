class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1),temp=head;
        int c = 0;
        
        while (l1 != null || l2 != null || c != 0) {
            if (l1 != null) {
                c += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                c += l2.val;
                l2 = l2.next;
            }

            temp = temp.next = new ListNode(c % 10);
            c/=10;
        }
        return head.next;
    }
}
