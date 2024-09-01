class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        boolean leftToRight = true;
        
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = leftToRight ? Q.pollFirst() : Q.pollLast();
                level.add(node.val);
                
                if (leftToRight) {
                    if (node.left != null) Q.addLast(node.left);
                    if (node.right != null) Q.addLast(node.right);
                } else {
                    if (node.right != null) Q.addFirst(node.right);
                    if (node.left != null) Q.addFirst(node.left);
                }
            }
            
            ans.add(level);
            leftToRight = !leftToRight; // Toggle the direction
        }
        
        return ans;
    }
}
