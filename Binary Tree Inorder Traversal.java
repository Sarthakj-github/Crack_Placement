class Solution {
    List<Integer> L = new ArrayList<>(); 
    public List<Integer> inorderTraversal(TreeNode root) {
        trav(root);
        return L;
    }
    public void trav(TreeNode root){
        if(root!=null){
            trav(root.left);
            L.add(root.val);
            trav(root.right);
        }
    }
}
