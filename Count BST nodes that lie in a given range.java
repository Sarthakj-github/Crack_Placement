class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        return trav(root,l,h);
    }
    
    int trav(Node root,int l,int h){
        if(root!=null){
            if(root.data<l){
                return trav(root.right,l,h);
            }
            else if(root.data>h){
                return trav(root.left,l,h);
            }
            else{
                return 1+trav(root.left,l,h)+trav(root.right,l,h);
            }
        }
        return 0;
    }
}
