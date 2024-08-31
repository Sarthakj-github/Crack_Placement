class Solution {
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    
    private void mapParents(TreeNode node, TreeNode parent) {
        if (node != null) {
            parentMap.put(node, parent);
            mapParents(node.left, node);
            mapParents(node.right, node);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mapParents(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int level = 0;
        while (!queue.isEmpty() && level++ < k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = parentMap.get(node);

                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.add(node.right);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }
}
