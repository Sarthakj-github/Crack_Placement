class Solution {
    public boolean isValidBST(TreeNode root) {
        return trav(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean trav(TreeNode root,long l,long r){
         if (root == null) {
            return true;
        }
        if (!(l < root.val && root.val < r)) {
            return false;
        }
        return trav(root.left, l, root.val) && trav(root.right, root.val, r);
    }
}
