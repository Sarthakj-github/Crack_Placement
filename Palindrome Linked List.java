class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev=null,slow=head,fast=head,next; 

        while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                next=slow.next;
                slow.next=prev;
                prev=slow;  slow=next;
        }
        fast = (fast!=null)?slow.next:slow; slow=prev;
        
        while(slow!=null && slow.val==fast.val){
            slow=slow.next;
            fast=fast.next;
        }
        return slow==null;


    }
}
