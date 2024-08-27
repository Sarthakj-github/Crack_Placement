class Solution {
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        trav(root,k-1);
        return ans;
    }
    int trav(TreeNode root,int k){
        if(root!=null){
            k = trav(root.left,k);
            if(k==0)    ans=root.val;
            return trav(root.right,k-1);
        }
        return k;
    }
}
