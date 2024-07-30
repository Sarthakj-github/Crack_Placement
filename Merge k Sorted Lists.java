class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> Q = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode list:lists){
            if(list!=null)
                Q.add(list);
        }

        ListNode h = new ListNode(-1);
        ListNode t = h,cur;


        while(!Q.isEmpty()){
            cur=Q.poll();
            if(cur.next!=null){
                Q.add(cur.next);
                cur.next=null;
            }
            t.next=cur;
            t=t.next;
        }
        return h.next;
    }
}
