class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	    //  Your code here
	    return trav(root)[0];
    }
    
    Node[] trav(Node root){
        if(root!=null){
            Node[] l,r;
            Node s=root,e=root;
            l=trav(root.left);
            if(l!=null){
                root.left=l[1];
                l[1].right=root;
                s=l[0];
            }
            r=trav(root.right);
            if(r!=null){
                root.right=r[0];
                r[0].left=root;
                e=r[1];
            }
            return new Node[]{s,e};
        }
        return null;
    }
}
