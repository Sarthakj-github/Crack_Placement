class Solution {
    List<Integer> arr;

    public int getMinimumDifference(TreeNode root) {
        arr = new ArrayList<>();
        trav(root);
        int m = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            m = Math.min(m, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        return m;
    }

    void trav(TreeNode root) {
        if (root.left != null) trav(root.left);
        arr.add(root.val);
        if (root.right != null) trav(root.right);
    }
}
