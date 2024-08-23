class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair<TreeNode, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(root, 0));

        while (!Q.isEmpty()) {
            Pair<TreeNode, Integer> pair = Q.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if (ans.size() == level)
                ans.add(new ArrayList<>());
            ans.get(level).add(node.val);

            if (node.left != null) Q.add(new Pair<>(node.left, level + 1));
            if (node.right != null) Q.add(new Pair<>(node.right, level + 1));
        }

        return ans;
    }
}
