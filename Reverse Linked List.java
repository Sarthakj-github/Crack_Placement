class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,nxt;
        while(head!=null){
            nxt=head.next;
            head.next=prev;
            prev=head;  
        }
        return prev;
    }
}
