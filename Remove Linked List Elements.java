class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev=null,temp=head;
        while(temp!=null){
            if(temp.val==val){
                if(prev==null)
                    head=temp.next;
                else{
                    prev.next=temp.next;
                }
            }
            else{
                prev=temp;
            }
            temp=temp.next;
        }
        return head;
    }
}
