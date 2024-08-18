class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1!=root2){
            TreeNode node  = new TreeNode(0);
            if(root1!=null)   node.val+=root1.val;
            if(root2!=null)   node.val+=root2.val;
            node.left=mergeTrees(root1!=null?root1.left:root1,root2!=null?root2.left:root2);
            node.right=mergeTrees(root1!=null?root1.right:root1,root2!=null?root2.right:root2);
            return node;
        }
        return null;
    }
}
