class Solution {
    Node zigZag(Node head) {
        // add code here.
        int i=0;
        Node nxt=null,prev=null,temp=head;
        while(temp.next!=null){
            nxt=temp.next;
            if(i%2==0 && temp.data>nxt.data){
                temp.next=nxt.next;
                nxt.next=temp;
                if(prev==null)
                    head=nxt;
                else
                    prev.next=nxt;
                temp=nxt;
            }
            if(i%2==1 && temp.data<nxt.data){
                temp.next=nxt.next;
                nxt.next=temp;
                if(prev==null)
                    head=nxt;
                else
                    prev.next=nxt;
                temp=nxt;
            }
            prev=temp;
            temp=temp.next;
            i++;
        }
        return head;
    }
}
