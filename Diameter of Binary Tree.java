class Solution {
    int m;
    public int diameterOfBinaryTree(TreeNode root) {
        m=0;
        trav(root);
        return m;
    }
    int trav(TreeNode root){
        int l = (root.left!=null)?trav(root.left):0;
        int r = (root.right!=null)?trav(root.right):0;
        m=Math.max(m,l+r);
        return  Math.max(l,r)+1;
    }
}
