class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return isdeadn(root,1,10002);
    }
    
    static boolean isdeadn(Node root,int m,int M){
        if(root==null)  return false;
        if(root.left==null && root.right==null) return root.data==m && root.data==M;
        return isdeadn(root.left,m,root.data-1) || isdeadn(root.right,root.data+1,M);
    }   
}
