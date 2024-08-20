class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return trav(root,false);
    }

    int trav(TreeNode root, boolean l){
        if(root.left==null && root.right==null){
            if(l)   return root.val;
            else    return 0;
        }
        return (root.left!=null?trav(root.left,true):0) + (root.right!=null?trav(root.right,false):0);

    }
}
