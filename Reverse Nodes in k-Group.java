class Solution {
    private ListNode reverse(ListNode curr, ListNode prev) {
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode t1 = head, t2 = head, p1 = null;

        while (t2 != null) {
            len++;
            if (len == k) {
                len = 0;
                ListNode next = t2.next;
                t2.next = null;
                ListNode d = reverse(t1, next);
                if (p1 == null) {
                    head = d;
                } else {
                    p1.next = d;
                }
                p1 = t1;
                t1 = t2 = next;
            } else {
                t2 = t2.next;
            }
        }

        return head;
    }
}
