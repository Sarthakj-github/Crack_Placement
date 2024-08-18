class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        int z=0,o=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0)    z++;
            else if(temp.data==1)   o++;
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(z-->0)   temp.data=0;
            else if(o-->0)  temp.data=1;
            else    temp.data=2;
            temp=temp.next;
        }
        return head;
    }
}
