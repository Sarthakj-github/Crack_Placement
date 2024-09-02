class Solution {
    static Node subLinkedList(Node head1, Node head2) {
        // code here
        head1=reverse(head1);
        head2=reverse(head2);
        
        Node t1=head1,t2=head2;
        int c=0;
        while(t1!=null && t2!=null){
            if(t1.data>t2.data) c=1;
            if(t1.data<t2.data) c=2;
            t1=t1.next;
            t2=t2.next;
        }
        if(t1==null && (t2!=null || c==2)){
            t1=head1;
            head1=head2;
            head2=t1;
        }
        
        c=0;
        Node head=null;
        
        while(head1!=null || head2!=null){
            int p = head1.data+c;
            if(head2!=null){
                p-=head2.data;
                head2=head2.next;
            }
            if(p<0){
                p+=10;
                c=-1;
            }
            else    c=0;
            head1=head1.next;
            Node node = new Node(p);
            node.next=head;
            head=node;
        }
        
        while(head.data==0 && head.next!=null)
            head=head.next;
        
        return head;
    }
    
    static Node reverse(Node head){
        Node prev=null,nxt;
        while(head!=null){
            nxt=head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
}
