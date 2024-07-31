class Solution {
    TreeNode ans,P,Q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=null;   P=p;    Q=q;
        trav(root);
        return ans;
    }
    int trav(TreeNode root){
        if(root!=null){
            int a = (root==P || root==Q)?1:0;
            a+=trav(root.left)+trav(root.right);
            if(ans==null && a==2)   ans=root;
            return a;
        }
        return 0;
    }
}
