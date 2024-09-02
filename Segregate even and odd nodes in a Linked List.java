class Solution {
    Node divide(Node head) {
        // code here'
        Node he=new Node(-1),ho=new Node(-1);
        Node te=he,to=ho;
        
        while(head!=null){
            if(head.data%2==0){
                te.next=head;
                te=head;
            }
            else{
                to.next=head;
                to=head;
            }
            head=head.next;
        }
        to.next=null;
        te.next=ho.next;
        return he.next;
    }
}
