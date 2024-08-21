class Tree
{
    static List<Integer> nodes;
    public static float findMedian(Node root)
    {
        // code here.
        nodes = new ArrayList();
        trav(root);
        int n = nodes.size();
        if(n%2==0)  return (nodes.get(n/2)+nodes.get(n/2-1))/2.0f;
        return nodes.get(n/2);
    }
    
    static void trav(Node root){
        if(root.left!=null) trav(root.left);
        nodes.add(root.data);
        if(root.right!=null) trav(root.right);
    }
}
