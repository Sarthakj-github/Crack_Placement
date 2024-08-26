class Solution {
    public TreeNode flatten(TreeNode root) {
        if(root!=null){
            root.right=flatten(root.right);
            if(root.left!=null){
                TreeNode temp=flatten(root.left);
                while(temp.right!=null) temp=temp.right;
                temp.right=root.right;
                root.right=root.left;
                root.left=null;
            }
        }
        return root;
    }
}
