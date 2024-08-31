class BSTIterator {
    Stack<TreeNode> S = new Stack();
    public BSTIterator(TreeNode root) {
        pushing(root);
    }
    
    public int next() {
        TreeNode a=this.S.pop();
        pushing(a.right);
        return a.val;
    }
    
    public boolean hasNext() {
        if(S.isEmpty()) return false;
        return true;
    }
    public void pushing(TreeNode root){
        while(root!=null){
            this.S.add(root);
            root=root.left;
        }
    }
}
