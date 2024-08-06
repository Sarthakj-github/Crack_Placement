class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = part(head);
        ListNode headr = rev(mid.next);
        mid.next = null;
        merge(head, headr);
    }

    ListNode part(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode rev(ListNode head) {
        ListNode prev = null, curr = head,nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;    curr = nxt;
        }
        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1_next = l1.next,l2_next = l2.next;
            l1.next = l2;
            if (l1_next == null) break;
            l2.next = l1_next;
            l1 = l1_next;   l2 = l2_next;
        }
    }
}
