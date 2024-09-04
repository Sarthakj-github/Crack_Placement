class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<int[]> H = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
        Queue<Object[]> Q = new LinkedList<>();
        Q.add(new Object[]{0, 0, root});

        while (!Q.isEmpty()) {
            Object[] p = Q.poll();
            TreeNode node = (TreeNode) p[2];
            H.add(new int[]{(int) p[0], (int) p[1], node.val});
            if (node.left != null) Q.add(new Object[]{(int) p[0] - 1, (int) p[1] + 1, node.left});
            if (node.right != null) Q.add(new Object[]{(int) p[0] + 1, (int) p[1] + 1, node.right});
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int m = H.peek()[0];

        while (!H.isEmpty()) {
            int[] cur = H.poll();
            if (cur[0] != m) {
                ans.add(l);
                l = new ArrayList<>();
                m = cur[0];
            }
            l.add(cur[2]);
        }
        ans.add(l);
        return ans;
    }
}
