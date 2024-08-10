class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head.next!=null){
            head.next=compute(head.next);
            if(head.next!=null && head.data<head.next.data)
                return head.next;
        }
        return head;
    }
}
