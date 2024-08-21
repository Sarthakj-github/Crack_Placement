class Solution {
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        trav(root);
        return ans;
    }

    int trav(TreeNode root){
        if(root!=null && ans){
            int l = trav(root.left);
            int r = trav(root.right);
            if(Math.abs(l-r)>1) ans = false;
            return Math.max(l,r)+1;
        }
        return 0;
    }
}
