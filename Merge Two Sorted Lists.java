class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode d = h;
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                d.next=list2;
                list2=list2.next;
            }
            else{
                d.next=list1;
                list1=list1.next;
            }
            d=d.next;
        }
        if(list1!=null)   d.next=list1;
        if(list2!=null)   d.next=list2;
        return h.next;
    }
}
