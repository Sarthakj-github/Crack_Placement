class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        int i=1;
        ListNode start=null,end=null,pstart=null,nend=null,temp=head,prev=null,nxt;
        while(temp!=null){
            if(i==left){
                start=temp;
                pstart=prev;
            }
            if(i==right){
                end=temp;
                nend=temp.next;
                break;
            }
            prev=temp;
            temp=temp.next;
            i++;
        }
        temp=start;
        prev=nend;
        while(prev!=end){
            nxt=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nxt;
        }
        if(pstart!=null)
            pstart.next=end;
        else
            return end;
        return head;
    }
}
