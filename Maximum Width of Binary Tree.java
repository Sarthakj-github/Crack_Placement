class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair<TreeNode, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(root, 0));  // Start with position 0 to avoid overflow
        int maxWidth = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();
            int minPos = Q.peek().getValue();  // The first node's position in the current level
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curr = Q.poll();
                TreeNode node = curr.getKey();
                int pos = curr.getValue() - minPos;  // Normalize to avoid overflow
                
                if (i == 0) start = pos;
                if (i == size - 1) end = pos;

                if (node.left != null) Q.add(new Pair<>(node.left, 2 * pos));
                if (node.right != null) Q.add(new Pair<>(node.right, 2 * pos + 1));
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        
        return maxWidth;
    }
}
