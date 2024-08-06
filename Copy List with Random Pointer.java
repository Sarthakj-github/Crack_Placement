class Solution {
    Map<Node,Node> d;
    public Node copyRandomList(Node head) {
        d=new HashMap<>();
        d.put(null,null);
        trav(head);
        return d.get(head);
    }
    void trav(Node head){
        if(head!=null){
            if(!d.containsKey(head))    d.put(head,new Node(head.val));
            if(!d.containsKey(head.random)) d.put(head.random,new Node(head.random.val));
            if(!d.containsKey(head.next))    d.put(head.next,new Node(head.next.val));
            Node node = d.get(head);
            node.next=d.get(head.next);
            node.random=d.get(head.random);
            trav(head.next);
        }
    }
}
