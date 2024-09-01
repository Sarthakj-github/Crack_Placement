class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,node;

        Stack<Integer> S1 = new Stack();
        Stack<Integer> S2 = new Stack();

        while(l1!=null){
            S1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            S2.push(l2.val);
            l2=l2.next;
        }

        int c=0,s;


        while(!S1.isEmpty() || !S2.isEmpty()){
            s = (S1.isEmpty()?0:S1.pop())+(S2.isEmpty()?0:S2.pop())+c;
            node = new ListNode(s%10);
            node.next=head; head=node;
            c = s/10;
        }

        if(c==1){
            node = new ListNode(1);
            node.next=head; head=node;
        }

        return head;

    }
}
